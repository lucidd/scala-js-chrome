package chrome.webNavigation.bindings

import chrome.tabs.bindings.Tab

import scala.scalajs.js

@js.native
trait GetFrameOptions extends js.Object {

  /**
   * The ID of the tab in which the frame is.
   */
  val tabId: Tab.Id

  /**
   *  Deprecated since Chrome 49. Frames are now uniquely identified by their tab ID and frame ID;
   *  the process ID is no longer needed and therefore ignored.
   *  The ID of the process that runs the renderer for this tab.
   */
  val processId: js.UndefOr[Int]

  /**
   *  The ID of the frame in the given tab.
   */
  val frameId: Int
}

object GetFrameOptions {

  def apply(tabId: Tab.Id, processId: js.UndefOr[Int] = js.undefined, frameId: Int): GetFrameOptions =
    js.Dynamic
      .literal(
        tabId = tabId,
        processId = processId,
        frameId = frameId
      )
      .asInstanceOf[GetFrameOptions]
}
