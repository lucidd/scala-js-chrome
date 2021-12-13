package chrome.webRequest.bindings

import scala.scalajs.js

object BlockingResponse {

  def apply(
      cancel: js.UndefOr[Boolean] = js.undefined,
      redirectUrl: js.UndefOr[String] = js.undefined,
      responseHeaders: js.UndefOr[js.Array[HttpHeader]] = js.undefined,
      authCredentials: js.UndefOr[AuthCredentials] = js.undefined,
      requestHeaders: js.UndefOr[js.Array[HttpHeader]] = js.undefined
  ): BlockingResponse = {
    js.Dynamic
      .literal(
        cancel = cancel,
        redirectUrl = redirectUrl,
        responseHeaders = responseHeaders,
        authCredentials = authCredentials,
        requestHeaders = requestHeaders
      )
      .asInstanceOf[BlockingResponse]
  }
}

@js.native
trait BlockingResponse extends js.Object {

  /** Optional: If true, the request is cancelled. Used in onBeforeRequest, this prevents the request from being sent.
    */
  val cancel: js.UndefOr[Boolean] = js.native

  /** Optional: Only used as a response to the onBeforeRequest and onHeadersReceived events. If set, the original
    * request is prevented from being sent/completed and is instead redirected to the given URL. Redirections to
    * non-HTTP schemes such as data: are allowed. Redirects initiated by a redirect action use the original request
    * method for the redirect, with one exception: If the redirect is initiated at the onHeadersReceived stage, then the
    * redirect will be issued using the GET method.
    */
  val redirectUrl: js.UndefOr[String] = js.native

  /** Optional: Only used as a response to the onHeadersReceived event. If set, the server is assumed to have responded
    * with these response headers instead. Only return responseHeaders if you really want to modify the headers in order
    * to limit the number of conflicts (only one extension may modify responseHeaders for each request).
    */
  val responseHeaders: js.UndefOr[js.Array[HttpHeader]] = js.native

  /** Optional: Only used as a response to the onAuthRequired event. If set, the request is made using the supplied
    * credentials.
    */
  val authCredentials: js.UndefOr[AuthCredentials] = js.native

  /** Optional: Only used as a response to the onBeforeSendHeaders event. If set, the request is made with these request
    * headers instead.
    */
  val requestHeaders: js.UndefOr[js.Array[HttpHeader]] = js.native
}
