package chrome.browserAction

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import chrome.events.bindings.Event
import chrome.tabs.bindings.Tab

@js.native
@JSName("chrome.browserAction")
object BrowserAction extends js.Object {
  val onClicked: Event[js.Function1[Tab, _]] = js.native
}
