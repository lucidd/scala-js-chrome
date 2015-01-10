package chrome.runtime

import chrome.events.Event
import chrome.runtime.bindings._
import org.scalajs.dom.Window
import scala.scalajs.js.JSConverters._

import scala.concurrent.{Promise, Future}
import scala.scalajs.js


sealed trait UpdateCheckResult
case class NoUpdate() extends UpdateCheckResult
case class UpdateAvailable(version: String) extends UpdateCheckResult
case class Throttled() extends UpdateCheckResult

object Runtime {

  val id: bindings.Runtime.AppID = bindings.Runtime.id
  def lastError: Option[Error] = bindings.Runtime.lastError.toOption

  def getBackgroundPage: Future[Window] = {
    val promise = Promise[Window]
    bindings.Runtime.getBackgroundPage((window: Window) => {
      promise.complete(chrome.lastErrorOrValue(window))
    })
    promise.future
  }
  
  def reload: Unit = bindings.Runtime.reload()
  def restart: Unit = bindings.Runtime.restart()

  def getManifest: Manifest = bindings.Runtime.getManifest()
  def getURL(path: String): String = bindings.Runtime.getURL(path)
  def setUninstallURL(url: String): Unit = bindings.Runtime.setUninstallURL(url)

  def requestUpdateCheck: Future[UpdateCheckResult] = {
    val promise = Promise[UpdateCheckResult]
    bindings.Runtime.requestUpdateCheck((status: UpdateCheck.Status, details: js.UndefOr[UpdateCheck.Details]) => {
      promise.complete(
        chrome.lastErrorOrValue(
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

  def connect(extensionId: js.UndefOr[String] = js.undefined, connectInfo: js.UndefOr[ConnectInfo] = js.undefined): Port = {
    bindings.Runtime.connect(extensionId, connectInfo)
  }
  
  def connectNative(application: String): Port = {
    bindings.Runtime.connectNative(application)
  }

  def sendMessage(extensionId: js.UndefOr[String] = js.undefined, message: js.Object, options: js.UndefOr[SendMessageOptions] = js.undefined, responseCallback: js.UndefOr[js.Function1[js.Object, _]]): Unit = {
    bindings.Runtime.sendMessage(extensionId, message, options, responseCallback)
  }
  
  def sendNativeMessage(application: String, message: js.Object, responseCallback: js.UndefOr[js.Function1[js.Object, _]]): Unit = {
    bindings.Runtime.sendNativeMessage(application, message, responseCallback)
  }

  def getPlatformInfo: Future[PlatformInfo] = {
    val promise = Promise[PlatformInfo]
    bindings.Runtime.getPlatformInfo((info: PlatformInfo) => {
      promise.complete(chrome.lastErrorOrValue(info))
    })
    promise.future
  }
  
  def getPackageDirectoryEntry: Future[DirectoryEntry] = {
    val promise = Promise[DirectoryEntry]
    bindings.Runtime.getPackageDirectoryEntry((dir: DirectoryEntry) => {
      promise.complete(chrome.lastErrorOrValue(dir))
    })
    promise.future
  }
  
  val onStartup: Event[js.Function0[_]] = bindings.Runtime.onStartup
  val onInstalled: Event[js.Function1[OnInstalledDetails, _]] = bindings.Runtime.onInstalled
  val onSuspend: Event[js.Function0[_]] = bindings.Runtime.onSuspend
  val onSuspendCanceled: Event[js.Function0[_]] = bindings.Runtime.onSuspendCanceled
  val onUpdateAvailable: Event[js.Function1[OnUpdateAvailableDetails, _]] = bindings.Runtime.onUpdateAvailable
  val onBrowserUpdateAvailable: Event[js.Function0[_]] = bindings.Runtime.onBrowserUpdateAvailable
  val onConnect: Event[js.Function1[Port, _]] = bindings.Runtime.onConnect
  val onConnectExternal: Event[js.Function1[Port, _]] = bindings.Runtime.onConnectExternal
  val onMessage: Event[js.Function3[js.UndefOr[js.Object], MessageSender, js.Function1[js.Object, _], Boolean]] = bindings.Runtime.onMessage
  val onMessageExternal: Event[js.Function3[js.UndefOr[js.Object], MessageSender, js.Function1[js.Object, _], Boolean]] = bindings.Runtime.onMessageExternal
  val onRestartRequired: Event[js.Function1[RestartReasons.RestartReason, _]] = bindings.Runtime.onRestartRequired
  
}
