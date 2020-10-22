package chrome.webNavigation.bindings

import scala.scalajs.js
import scala.scalajs.js.native

@js.native
trait AllFramesDetails extends js.Object {

  /**
   * True if the last navigation in this frame was interrupted by an error, i.e. the onErrorOccurred event fired.
   */
  val errorOccurred: Boolean = native

  /**
   *  The ID of the process that runs the renderer for this frame.
   */
  val processId: js.UndefOr[Int] = native

  /**
   * The ID of the frame. 0 indicates that this is the main frame; a positive value indicates the ID of a subframe.
   */
  val frameId: Int = native

  /**
   * ID of frame that wraps the frame. Set to -1 if no parent frame exists.
   */
  val frameParentId: Int = native

  /**
   * The URL currently associated with this frame.
   */
  val url: String = native
}
