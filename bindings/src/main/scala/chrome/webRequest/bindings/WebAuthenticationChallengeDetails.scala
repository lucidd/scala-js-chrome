package chrome.webRequest.bindings

import scala.scalajs.js

@js.native
trait WebAuthenticationChallengeDetails extends WebResponseHeadersDetails {

  /**
   * The authentication scheme, e.g. Basic or Digest.
   */
  val scheme: String = js.native

  /**
   * The authentication realm provided by the server, if there is one.
   */
  val realm: js.UndefOr[String] = js.native

  /**
   * The server requesting authentication.
   */
  val challenger: WebAuthChallenger = js.native

  /**
   * True for Proxy-Authenticate, false for WWW-Authenticate.
   */
  val isProxy: Boolean = js.native
}
