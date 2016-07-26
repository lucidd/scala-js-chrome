package chrome.runtime.bindings

import chrome.events.bindings.Event
import org.scalajs.dom.Window

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.{UndefOr, native, undefined}

@JSName("chrome.runtime")
@js.native
object Runtime extends js.Object {

  type AppID = String

  val id: AppID = native
  val onStartup: Event[js.Function0[_]] = native
  val onInstalled: Event[js.Function1[OnInstalledDetails, _]] = native
  val onSuspend: Event[js.Function0[_]] = native
  val onSuspendCanceled: Event[js.Function0[_]] = native
  val onUpdateAvailable: Event[js.Function1[OnUpdateAvailableDetails, _]] =
    native
  val onBrowserUpdateAvailable: Event[js.Function0[_]] = native
  val onConnect: Event[js.Function1[Port, _]] = native
  val onConnectExternal: Event[js.Function1[Port, _]] = native
  val onMessage: Event[js.Function3[UndefOr[Any],
                                    MessageSender,
                                    js.Function1[Any, _],
                                    Boolean]] = native
  val onMessageExternal: Event[js.Function3[UndefOr[Any],
                                            MessageSender,
                                            js.Function1[Any, _],
                                            Boolean]] = native
  val onRestartRequired: Event[js.Function1[RestartReasons.RestartReason, _]] =
    native

  def lastError: UndefOr[Error] = native

  def getBackgroundPage(callback: js.Function1[Window, _]): Unit = native

  def reload(): Unit = native

  def restart(): Unit = native

  def getManifest(): Manifest = native

  def openOptionsPage(callback: js.UndefOr[js.Function0[_]]): Unit = js.native

  def getURL(path: String): String = native

  def setUninstallURL(url: String): Unit = native

  def requestUpdateCheck(
      callback: js.Function2[UpdateCheck.Status,
                             UndefOr[UpdateCheck.Details],
                             _]): Unit = native

  def connect(extensionId: UndefOr[AppID] = undefined,
              connectInfo: UndefOr[ConnectInfo] = undefined): Port = native

  def connectNative(application: String): Port = native

  def sendMessage(extensionId: UndefOr[AppID] = undefined,
                  message: js.Any,
                  options: UndefOr[SendMessageOptions] = undefined,
                  responseCallback: UndefOr[js.Function1[js.Object, _]] =
                    js.undefined): Unit = native

  def sendNativeMessage(
      application: String,
      message: js.Object,
      responseCallback: UndefOr[js.Function1[js.Object, _]]): Unit = native

  def getPlatformInfo(callback: js.Function1[PlatformInfo, _]): Unit = native

  def getPackageDirectoryEntry(
      callback: js.Function1[DirectoryEntry, _]): Unit = native

}

object UpdateCheck {

  type Status = String

  val THROTTLED: Status = "throttled"
  val NO_UPDATE: Status = "no_update"
  val UPDATE_AVAILABLE: Status = "update_available"

  @js.native
  trait Details extends js.Object {

    val version: String = native

  }

}

object RestartReasons {

  type RestartReason = String

  val APP_UPDATE: RestartReason = "app_update"
  val OS_UPDATE: RestartReason = "os_update"
  val PERIODIC: RestartReason = "periodic"

}
