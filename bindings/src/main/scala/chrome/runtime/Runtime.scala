package chrome.runtime

import chrome.Impl.{ExtensionManifest, Background, App, AppManifest}
import chrome.events.EventSourceImplicits._
import chrome.events.bindings.Event
import chrome.events.{EventSource, Subscription}
import chrome.permissions.{Permission, Permissions}
import chrome.runtime.bindings.Runtime.AppID
import chrome.runtime.bindings._
import org.scalajs.dom.Window
import utils.ErrorHandling.lastErrorOrValue

import scala.concurrent.{Future, Promise}
import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}
import scala.util.{Failure, Success}


sealed trait UpdateCheckResult

case class NoUpdate() extends UpdateCheckResult

case class UpdateAvailable(version: String) extends UpdateCheckResult

case class Throttled() extends UpdateCheckResult

object Runtime {

  val id: bindings.Runtime.AppID = bindings.Runtime.id
  val onStartup: EventSource[Unit] = bindings.Runtime.onStartup
  val onInstalled: EventSource[OnInstalledDetails] = bindings.Runtime.onInstalled
  val onSuspend: EventSource[Unit] = bindings.Runtime.onSuspend
  val onSuspendCanceled: EventSource[Unit] = bindings.Runtime.onSuspendCanceled
  val onUpdateAvailable: EventSource[OnUpdateAvailableDetails] = bindings.Runtime.onUpdateAvailable
  val onBrowserUpdateAvailable: EventSource[Unit] = bindings.Runtime.onBrowserUpdateAvailable
  val onConnect: EventSource[Port] = bindings.Runtime.onConnect
  val onConnectExternal: EventSource[Port] = bindings.Runtime.onConnectExternal

  class Message[A, R](val value: A, val sender: MessageSender, sendResponse: js.Function1[R, _]) {

    private[Runtime] var async = false

    def response(response: R): Unit = {
      sendResponse(response)
      async = false
    }

    def response(asyncResponse: Future[R], failure: => R): Unit = {
      import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
      asyncResponse.onComplete {
        case Success(value) => sendResponse(value)
        case Failure(error) => sendResponse(failure)
      }
      async = true
    }

  }

  class MessageEventSource(event: Event[js.Function3[UndefOr[Any], MessageSender, js.Function1[Any, _], Boolean]])
    extends EventSource[Message[Option[Any], Any]] {

    class SubscriptionImpl(fn: Message[Option[Any], Any] => Unit) extends Subscription {

      val fn2 = (msg: UndefOr[Any], sender: MessageSender, sendResponse: js.Function1[Any, _]) => {
        val message = new Message[Option[Any], Any](msg.toOption, sender, sendResponse)
        fn(message)
        message.async
      }

      event.addListener(fn2)

      def cancel(): Unit = {
        event.removeListener(fn2)
      }

    }

    def listen(fn: Message[Option[Any], Any] => Unit): Subscription = {
      new SubscriptionImpl(fn)
    }

  }

  val onMessage: EventSource[Message[Option[Any], Any]] = new MessageEventSource(bindings.Runtime.onMessage)
  val onMessageExternal: EventSource[Message[Option[Any], Any]] =
    new MessageEventSource(bindings.Runtime.onMessageExternal)
  val onRestartRequired: EventSource[RestartReasons.RestartReason] = bindings.Runtime.onRestartRequired

  def lastError: Option[Error] = bindings.Runtime.lastError.toOption

  def getBackgroundPage: Future[Window] = {
    val promise = Promise[Window]()
    bindings.Runtime.getBackgroundPage((window: Window) => {
      promise.complete(lastErrorOrValue(window))
    })
    promise.future
  }

  def reload(): Unit = bindings.Runtime.reload()

  def restart(): Unit = bindings.Runtime.restart()

  def getManifest: chrome.Manifest = {
    val manifest = bindings.Runtime.getManifest()
    val perms = manifest.permissions.map(_.foldLeft(Set[Permission]()){
      case (acc, perm) => acc ++ Permissions.permissionFromString(perm)
    }).getOrElse(Set())
    val icons = for {
      (k, v) <- manifest.icons.getOrElse(Map())
    } yield k.toInt -> v
    if (manifest.isAppManifest) {
      val app = manifest.asAppManifest.get
      AppManifest(
        app = App(
          background = Background(
            scripts = app.app.background.scripts.toList
          )
        ),
        name = manifest.name,
        version = manifest.version,
        manifestVersion = manifest.manifest_version,
        shortName = manifest.shortName.toOption,
        defaultLocale = manifest.defaultLocale.toOption,
        description = manifest.description.toOption,
        offlineEnabled = manifest.offlineEnabled.getOrElse(true),
        permissions = perms,
        icons = icons
      )
    } else {
      val extension = manifest.asExtensionManifest.get
      ExtensionManifest(
        name = manifest.name,
        version = manifest.version,
        manifestVersion = manifest.manifest_version,
        shortName = manifest.shortName.toOption,
        defaultLocale = manifest.defaultLocale.toOption,
        description = manifest.description.toOption,
        offlineEnabled = manifest.offlineEnabled.getOrElse(true),
        permissions = perms,
        icons = icons,
        background = Background(
          scripts = extension.background.map(_.scripts.toList).getOrElse(List())
        )
      )
    }
  }

  def openOptionsPage: Future[Unit] = {
    val promise = Promise[Unit]
    bindings.Runtime.openOptionsPage(js.Any.fromFunction0(() => {
      promise.complete(lastErrorOrValue(()))
    }))
    promise.future
  }

  def getURL(path: String): String = bindings.Runtime.getURL(path)

  def setUninstallURL(url: String): Unit = bindings.Runtime.setUninstallURL(url)

  def requestUpdateCheck: Future[UpdateCheckResult] = {
    val promise = Promise[UpdateCheckResult]()
    bindings.Runtime.requestUpdateCheck((status: UpdateCheck.Status, details: UndefOr[UpdateCheck.Details]) => {
      promise.complete(
        lastErrorOrValue(
          status match {
            case UpdateCheck.UPDATE_AVAILABLE => UpdateAvailable(details.get.version)
            case UpdateCheck.NO_UPDATE => NoUpdate()
            case UpdateCheck.THROTTLED => Throttled()
          }
        )
      )
    })
    promise.future
  }

  def connect(extensionId: UndefOr[AppID] = undefined, connectInfo: UndefOr[ConnectInfo] = undefined): Port = {
    bindings.Runtime.connect(extensionId, connectInfo)
  }

  def connectNative(application: String): Port = {
    bindings.Runtime.connectNative(application)
  }

  def sendMessage(extensionId: UndefOr[AppID] = undefined, message: js.Any,
                  options: UndefOr[SendMessageOptions] = undefined,
                  responseCallback: UndefOr[js.Function1[js.Object, _]] = js.undefined): Unit = {
    bindings.Runtime.sendMessage(extensionId, message, options, responseCallback)
  }

  def sendNativeMessage(application: String, message: js.Object,
                        responseCallback: UndefOr[js.Function1[js.Object, _]]): Unit = {
    bindings.Runtime.sendNativeMessage(application, message, responseCallback)
  }

  def getPlatformInfo: Future[PlatformInfo] = {
    val promise = Promise[PlatformInfo]()
    bindings.Runtime.getPlatformInfo((info: PlatformInfo) => {
      promise.complete(lastErrorOrValue(info))
    })
    promise.future
  }

  def getPackageDirectoryEntry: Future[DirectoryEntry] = {
    val promise = Promise[DirectoryEntry]()
    bindings.Runtime.getPackageDirectoryEntry((dir: DirectoryEntry) => {
      promise.complete(lastErrorOrValue(dir))
    })
    promise.future
  }

}
