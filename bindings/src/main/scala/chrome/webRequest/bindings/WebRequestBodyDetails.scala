package chrome.webRequest.bindings

import scala.scalajs.js

@js.native
trait WebRequestBodyDetails extends WebRequestDetails {

  /** Contains the HTTP request body data. Only provided if extraInfoSpec contains 'requestBody'.
    * @since Chrome
    *   23.
    */
  val requestBody: WebRequestBody = js.native
}
