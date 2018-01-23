package chrome.webRequest.bindings

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal("chrome.webRequest")
object WebRequest extends js.Object {

  // (R <: ResourceRequest) => Unit
  type Callback[R <: ResourceRequest] = js.Function1[R, Unit]
  // (R <: ResourceRequest) => ?BlockingResponse
  type BlockableCallback[R <: ResourceRequest] = js.Function1[R, js.UndefOr[BlockingResponse]]
  // (R <: ResourceRequest, ?(BlockingResponse) => _) => ?BlockingResponse
  type BlockableAuthCallback[R <: ResourceRequest] = js.Function2[R,
    js.UndefOr[js.Function1[BlockingResponse, _]], js.UndefOr[BlockingResponse]]

  /**
    * The maximum number of times that handlerBehaviorChanged can be called per 10 minute sustained interval.
    * handlerBehaviorChanged is an expensive function call that shouldn't be called often.
    *
    * @since Chrome 23.
    */
  val MAX_HANDLER_BEHAVIOR_CHANGED_CALLS_PER_10_MINUTES: Int = js.native

  /**
    * Needs to be called when the behavior of the webRequest handlers has changed to prevent incorrect handling due to
    * caching. This function call is expensive. Don't call it often.
    */
  def handlerBehaviorChanged(callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native

  /**
    * Fired when a request is about to occur.
    */
  var onBeforeRequest: WebRequestEvent[BlockableCallback[WebRequestBodyDetails]] = js.native

  /**
    * Fired before sending an HTTP request, once the request headers are available. This may occur after a TCP
    * connection is made to the server, but before any HTTP data is sent.
    */
  var onBeforeSendHeaders: WebRequestEvent[BlockableCallback[WebRequestHeadersDetails]] = js.native

  /**
    * Fired just before a request is going to be sent to the server (modifications of previous onBeforeSendHeaders
    * callbacks are visible by the time onSendHeaders is fired).
    */
  var onSendHeaders: WebRequestEvent[Callback[WebRequestHeadersDetails]] = js.native

  /**
    * Fired when HTTP response headers of a request have been received.
    */
  val onHeadersReceived: WebRequestEvent[BlockableCallback[WebResponseHeadersDetails]] = js.native

  /**
    * Fired when an authentication failure is received. The listener has three options: it can provide authentication
    * credentials, it can cancel the request and display the error page, or it can take no action on the challenge. If
    * bad user credentials are provided, this may be called multiple times for the same request.
    */
  var onAuthRequired: WebRequestEvent[BlockableAuthCallback[WebAuthenticationChallengeDetails]] = js.native

  /**
    * Fired when the first byte of the response body is received. For HTTP requests, this means that the status line
    * and response headers are available.
    */
  var onResponseStarted: WebRequestEvent[Callback[WebResponseCacheDetails]] = js.native

  /**
    * Fired when a server-initiated redirect is about to occur.
    */
  var onBeforeRedirect: WebRequestEvent[Callback[WebRedirectionResponseDetails]] = js.native

  /**
    * Fired when a request is completed.
    */
  var onCompleted: WebRequestEvent[Callback[WebResponseCacheDetails]] = js.native

  /**
    * Fired when an error occurs.
    */
  var onErrorOccurred: WebRequestEvent[Callback[WebResponseErrorDetails]] = js.native
}
