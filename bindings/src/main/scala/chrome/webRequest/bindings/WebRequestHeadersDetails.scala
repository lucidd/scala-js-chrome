package chrome.webRequest.bindings

import scala.scalajs.js

@js.native
trait WebRequestHeadersDetails extends WebRequestDetails {

  /**
   * Optional:
   * The HTTP request headers that are going to be sent out with this request.
   */
  val requestHeaders: js.UndefOr[js.Array[HttpHeader]] = js.native
}
