package chrome.webRequest.bindings

import scala.scalajs.js

@js.native
trait WebRedirectionResponseDetails extends WebResponseCacheDetails {
  /**
    * The new URL.
    */
  val redirectUrl: String = js.native
}