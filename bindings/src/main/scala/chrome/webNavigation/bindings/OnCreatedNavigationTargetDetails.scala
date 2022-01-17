package chrome.webNavigation.bindings

import scala.scalajs.js

@js.native
trait OnCreatedNavigationTargetDetails extends js.Object {

  /** The ID of the tab in which the navigation is triggered.
    */
  val sourceTabId: Int = js.native

  /** The ID of the process that runs the renderer for the source frame.
    *
    * Missing in firefox https://bugzilla.mozilla.org/show_bug.cgi?id=1248426
    */
  val sourceProcessId: js.UndefOr[Int] = js.native

  /** The ID of the frame with sourceTabId in which the navigation is triggered. 0 indicates the main frame.
    */
  val sourceFrameId: Int = js.native

  /** The URL to be opened in the new window.
    */
  val url: String = js.native

  /** The ID of the tab in which the url is opened.
    */
  val tabId: Int = js.native

  /** The time when the browser was about to create a new view, in milliseconds since the epoch.
    */
  val timeStamp: Double = js.native
}
