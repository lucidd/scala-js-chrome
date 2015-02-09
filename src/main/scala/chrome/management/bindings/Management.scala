package chrome.management.bindings

import chrome.events.bindings.Event
import chrome.management.bindings.ExtensionInfo.LaunchType

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@JSName("chrome.management")
object Management extends js.Object {
  
  def getAll(callback: js.Function1[js.Array[ExtensionInfo], _]): Unit = js.native
  def get(id: String, callback: js.Function1[ExtensionInfo, _]): Unit = js.native
  def getSelf(callback: js.Function1[ExtensionInfo, _]): Unit = js.native
  def getPermissionWarningsById(id: String, callback: js.Function1[js.Array[String], _]): Unit = js.native
  def getPermissionWarningsByManifest(manifestStr: String, callback: js.Function1[js.Array[String], _]): Unit = js.native
  def setEnabled(id: String, enabled: Boolean, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native
  def uninstall(id: String, options: js.UndefOr[js.Object] = js.undefined, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native
  def uninstallSelf(options: js.UndefOr[js.Object] = js.undefined, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native
  def launchApp(id: String, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native
  def createAppShortcut(id: String, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native
  def setLaunchType(id: String, launchType: LaunchType, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native
  def generateAppForLink(url: String, title: String, callback: js.UndefOr[js.Function1[ExtensionInfo, _]] = js.undefined): Unit = js.native
  
  val onInstalled: Event[js.Function1[ExtensionInfo, _]] = js.native
  val onUninstalled: Event[js.Function1[String, _]] = js.native
  val onEnabled: Event[js.Function1[ExtensionInfo, _]] = js.native
  val onDisabled: Event[js.Function1[ExtensionInfo, _]] = js.native

  
}



