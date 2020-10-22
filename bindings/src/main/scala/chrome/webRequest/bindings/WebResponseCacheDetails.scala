package chrome.webRequest.bindings

import scala.scalajs.js

@js.native
trait WebResponseCacheDetails extends WebResponseHeadersDetails {

  /**
   * Optional:
   * The server IP address that the request was actually sent to. Note that it may be a literal IPv6 address.
   */
  val ip: js.UndefOr[String] = js.native

  /**
   * Indicates if this response was fetched from disk cache.
   */
  val fromCache: Boolean = js.native
}
