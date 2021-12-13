package chrome.webRequest.bindings

import scala.scalajs.js

@js.native
trait WebResponseDetails extends ResourceRequest {

  /** HTTP status line of the response or the 'HTTP/0.9 200 OK' string for HTTP/0.9 responses (i.e., responses that lack
    * a status line).
    */
  val statusLine: String = js.native

  /** Standard HTTP status code returned by the server.
    * @since Chrome
    *   43.
    */
  val statusCode: Int = js.native
}
