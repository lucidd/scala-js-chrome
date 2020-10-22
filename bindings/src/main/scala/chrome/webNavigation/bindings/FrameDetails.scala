package chrome.webNavigation.bindings

import scala.scalajs.js
import scala.scalajs.js.native

@js.native
trait FrameDetails extends js.Object {

  /**
   * True if the last navigation in this frame was interrupted by an error, i.e. the onErrorOccurred event fired.
   */
  val errorOccurred: Boolean = native

  /**
   * The URL currently associated with this frame,
   * if the frame identified by the frameId existed at one point in the given tab.
   * The fact that an URL is associated with a given frameId does not imply that the corresponding frame still exists.
   */
  val url: String = native

  /**
   * ID of frame that wraps the frame. Set to -1 if no parent frame exists.
   */
  val frameParentId: Int = native
}
