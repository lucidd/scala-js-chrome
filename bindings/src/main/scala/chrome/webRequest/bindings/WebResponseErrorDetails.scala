package chrome.webRequest.bindings

import scala.scalajs.js

@js.native
trait WebResponseErrorDetails extends WebResponseCacheDetails {

  /**
   * The error description. This string is not guaranteed to remain backwards compatible between releases. You must
   * not parse and act based upon its content.
   */
  val error: String = js.native
}
