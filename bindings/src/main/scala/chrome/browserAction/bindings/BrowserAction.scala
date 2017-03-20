package chrome.browserAction.bindings

import chrome.events.bindings.Event
import chrome.tabs.bindings.Tab

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
@JSName("chrome.browserAction")
object BrowserAction extends js.Object {
  val onClicked: Event[js.Function1[Tab, _]] = js.native

  def setTitle(details: TitleDetails): Unit = js.native

  def getTitle(details: TabIdDetails, callback: js.Function1[String, _]): Unit = js.native

  def setIcon(details: IconDetails, callback: js.Function0[_]): Unit = js.native

  def setPopup(details: PopupDetails): Unit = js.native

  def getPopup(details: TabIdDetails, callback: js.Function1[String, _]): Unit = js.native

  def setBadgeText(details: BadgeTextDetails): Unit = js.native

  def getBadgeText(details: TabIdDetails, callback: js.Function1[String, _]): Unit = js.native

  def setBadgeBackgroundColor(details: BadgeBackgroundColorDetails): Unit = js.native

  def getBadgeBackgroundColor(details: TabIdDetails, callback: js.Function1[js.Array[Int], _]): Unit = js.native

  def enable(tabId: js.UndefOr[Int]): Unit = js.native

  def disable(tabId: js.UndefOr[Int]): Unit = js.native
}
