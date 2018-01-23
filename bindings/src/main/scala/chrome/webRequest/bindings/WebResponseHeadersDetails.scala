package chrome.webRequest.bindings

import scala.scalajs.js

@js.native
trait WebResponseHeadersDetails extends WebResponseDetails {
  /**
    * Optional:
    * The HTTP response headers that have been received with this response.
    */
  val responseHeaders: js.UndefOr[js.Array[HttpHeader]] = js.native

  /** standard HTTP method i.e. GET, POST, PUT, etc. */
  val method: String = js.native
}
