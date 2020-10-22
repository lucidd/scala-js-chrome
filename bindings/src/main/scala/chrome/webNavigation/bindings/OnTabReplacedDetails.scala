package chrome.webNavigation.bindings

import scala.scalajs.js
import scala.scalajs.js._

@js.native
trait OnTabReplacedDetails extends js.Object {

  /**
   *  The ID of the tab that was replaced.
   */
  val replacedTabId: Int = native

  /**
   *  The ID of the tab that replaced the old tab.
   */
  val tabId: Int = native

  /**
   * The time when the replacement happened, in milliseconds since the epoch.
   */
  val timeStamp: Double = native
}
