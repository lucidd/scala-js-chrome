package chrome.webRequest.bindings

import scala.scalajs.js

@js.native
trait WebRequestDetails extends ResourceRequest {
  /** Standard HTTP method. */
  val method: String = js.native
}
