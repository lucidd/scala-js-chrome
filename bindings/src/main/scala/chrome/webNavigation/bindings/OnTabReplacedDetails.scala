package chrome.webNavigation.bindings

import scala.scalajs.js

@js.native
trait OnTabReplacedDetails extends js.Object {

  /** The ID of the tab that was replaced.
    */
  val replacedTabId: Int = js.native

  /** The ID of the tab that replaced the old tab.
    */
  val tabId: Int = js.native

  /** The time when the replacement happened, in milliseconds since the epoch.
    */
  val timeStamp: Double = js.native
}
