package chrome.webRequest.bindings

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
trait ResourceRequest extends js.Object {

  val url: String = js.native

  /** The ID of the request. Request IDs are unique within a browser session. As a result, they could be used to relate
    * different events of the same request.
    */
  val requestId: String = js.native

  /** The value 0 indicates that the request happens in the main frame; a positive value indicates the ID of a subframe
    * in which the request happens. If the document of a (sub-)frame is loaded (type is main_frame or sub_frame),
    * frameId indicates the ID of this frame, not the ID of the outer frame. Frame IDs are unique within a tab.
    */
  val frameId: Int = js.native

  /** ID of frame that wraps the frame which sent the request. Set to -1 if no parent frame exists. */
  val parentFrameId: Int = js.native

  /** The ID of the tab in which the request takes place. Set to -1 if the request isn't related to a tab. */
  val tabId: Int = js.native

  /** How the requested resource will be used. One of: "main_frame", "sub_frame", "stylesheet", "script", "image",
    * "object", "xmlhttprequest", or "other"
    */
  @JSName("type")
  val resourceType: String = js.native

  /** The time when this signal is triggered, in milliseconds since the epoch. */
  val timeStamp: Int = js.native
}
