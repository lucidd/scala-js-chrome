package chrome.webNavigation.bindings

import scala.scalajs.js

@js.native
trait OnCompletedDetails extends js.Object {

  /** The ID of the tab in which the navigation occurs.
    */
  val tabId: Int = js.native
  val url: String = js.native

  /** The ID of the process that runs the renderer for this frame.
    *
    * Missing in firefox https://bugzilla.mozilla.org/show_bug.cgi?id=1248426
    */
  val processId: js.UndefOr[Int] = js.native

  /** 0 indicates the navigation happens in the tab content window; a positive value indicates navigation in a subframe.
    * Frame IDs are unique within a tab.
    */
  val frameId: Int = js.native

  /** The time when the document finished loading, in milliseconds since the epoch.
    */
  val timeStamp: Double = js.native
}
