package chrome.management.bindings

import chrome.events.bindings.Event
import chrome.management.bindings.ExtensionInfo.LaunchType
import chrome.runtime.bindings.Runtime.AppID

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
@JSName("chrome.management")
object Management extends js.Object {

  val onInstalled: Event[js.Function1[ExtensionInfo, _]] = js.native
  val onUninstalled: Event[js.Function1[String, _]] = js.native
  val onEnabled: Event[js.Function1[ExtensionInfo, _]] = js.native
  val onDisabled: Event[js.Function1[ExtensionInfo, _]] = js.native

  def getAll(callback: js.Function1[js.Array[ExtensionInfo], _]): Unit = js.native

  def get(id: AppID, callback: js.Function1[ExtensionInfo, _]): Unit = js.native

  def getSelf(callback: js.Function1[ExtensionInfo, _]): Unit = js.native

  def getPermissionWarningsById(id: AppID, callback: js.Function1[js.Array[String], _]): Unit = js.native

  def getPermissionWarningsByManifest(manifestStr: String,
                                      callback: js.Function1[js.Array[String], _]): Unit = js.native

  def setEnabled(id: AppID, enabled: Boolean, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native

  def uninstall(id: AppID, options: js.UndefOr[js.Object] = js.undefined,
                callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native

  def uninstallSelf(options: js.UndefOr[js.Object] = js.undefined,
                    callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native

  def launchApp(id: AppID, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native

  def createAppShortcut(id: AppID, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native

  def setLaunchType(id: AppID, launchType: LaunchType,
                    callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native

  def generateAppForLink(url: String, title: String,
                         callback: js.UndefOr[js.Function1[ExtensionInfo, _]] = js.undefined): Unit = js.native


}



