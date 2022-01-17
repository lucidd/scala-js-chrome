package chrome.runtime.bindings

import chrome.events.bindings.Event
import org.scalajs.dom.Window

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.{UndefOr, undefined}

@JSGlobal("chrome.runtime")
@js.native
object Runtime extends js.Object {

  type AppID = String

  val id: AppID = js.native
  val onStartup: Event[js.Function0[_]] = js.native
  val onInstalled: Event[js.Function1[OnInstalledDetails, _]] = js.native
  val onSuspend: Event[js.Function0[_]] = js.native
  val onSuspendCanceled: Event[js.Function0[_]] = js.native

  val onUpdateAvailable: Event[js.Function1[OnUpdateAvailableDetails, _]] =
    js.native
  val onBrowserUpdateAvailable: Event[js.Function0[_]] = js.native
  val onConnect: Event[js.Function1[Port, _]] = js.native
  val onConnectExternal: Event[js.Function1[Port, _]] = js.native
  val onMessage: Event[js.Function3[UndefOr[Any], MessageSender, js.Function1[Any, _], Boolean]] = js.native
  val onMessageExternal: Event[js.Function3[UndefOr[Any], MessageSender, js.Function1[Any, _], Boolean]] = js.native

  val onRestartRequired: Event[js.Function1[RestartReasons.RestartReason, _]] =
    js.native

  def lastError: UndefOr[Error] = js.native

  def getBackgroundPage(callback: js.Function1[Window, _]): Unit = js.native

  def reload(): Unit = js.native

  def restart(): Unit = js.native

  def getManifest(): Manifest = js.native

  def openOptionsPage(callback: js.UndefOr[js.Function0[_]]): Unit = js.native

  def getURL(path: String): String = js.native

  def setUninstallURL(url: String): Unit = js.native

  def requestUpdateCheck(callback: js.Function2[UpdateCheck.Status, UndefOr[UpdateCheck.Details], _]): Unit = js.native

  def connect(extensionId: UndefOr[AppID] = undefined, connectInfo: UndefOr[ConnectInfo] = undefined): Port = js.native

  def connectNative(application: String): Port = js.native

  def sendMessage(
      extensionId: UndefOr[AppID] = undefined,
      message: js.Any,
      options: UndefOr[SendMessageOptions] = undefined,
      responseCallback: UndefOr[js.Function1[js.Object, _]] = js.undefined
  ): Unit = js.native

  def sendNativeMessage(
      application: String,
      message: js.Object,
      responseCallback: UndefOr[js.Function1[js.Object, _]]
  ): Unit = js.native

  def getPlatformInfo(callback: js.Function1[PlatformInfo, _]): Unit = js.native

  def getPackageDirectoryEntry(callback: js.Function1[DirectoryEntry, _]): Unit = js.native

}

object UpdateCheck {

  type Status = String

  val THROTTLED: Status = "throttled"
  val NO_UPDATE: Status = "no_update"
  val UPDATE_AVAILABLE: Status = "update_available"

  @js.native
  trait Details extends js.Object {

    val version: String = js.native

  }

}

object RestartReasons {

  type RestartReason = String

  val APP_UPDATE: RestartReason = "app_update"
  val OS_UPDATE: RestartReason = "os_update"
  val PERIODIC: RestartReason = "periodic"

}
