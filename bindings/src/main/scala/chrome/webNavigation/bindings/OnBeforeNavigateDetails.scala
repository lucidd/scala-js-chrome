package chrome.webNavigation.bindings

import scala.scalajs.js
import scala.scalajs.js._

@js.native
trait OnBeforeNavigateDetails extends js.Object {
  /**
    * The ID of the tab in which the navigation is about to occur.
    */
  val tabId: Int = native
  val url: String = native
  /**
    *  Deprecated since Chrome 50.
    *  The processId is no longer set for this event, since the process which will render the resulting document is not
    *  known until onCommit.
    *  Always returns the value of -1.
    *
    *  Missing in firefox https://bugzilla.mozilla.org/show_bug.cgi?id=1248426
    */
  val processId: js.UndefOr[Int] = native
  /**
    * 0 indicates the navigation happens in the tab content window; a positive value indicates navigation in a subframe.
    * Frame IDs are unique for a given tab and process.
    */
  val frameId: Int = native
  /**
    * Since Chrome 24.
    * ID of frame that wraps the frame. Set to -1 of no parent frame exists.
    */
  val parentFrameId: Int = native
  /**
    * The time when the browser was about to start the navigation, in milliseconds since the epoch.
    */
  val timeStamp: Double = native
}
