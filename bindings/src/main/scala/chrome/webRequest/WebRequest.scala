package chrome.webRequest

import chrome.ChromeAPI
import chrome.permissions.Permission.API
import chrome.webRequest.bindings.WebRequest.{BlockableAuthCallback, BlockableCallback, Callback}
import chrome.webRequest.bindings._

import scala.scalajs.js


/**
  * @see <a href="https://developer.chrome.com/extensions/webRequest">chrome.webRequest API</a>
  */
object WebRequest extends ChromeAPI {
  override val requiredPermissions: Set[API] = Set(API.WebRequest)

  val MaxHandlerBehaviorChangedCallsPer10Minutes: Int = {
    bindings.WebRequest.MAX_HANDLER_BEHAVIOR_CHANGED_CALLS_PER_10_MINUTES
  }

  /**
    * Needs to be called when the behavior of the webRequest handlers has changed to prevent incorrect handling due to
    * caching. This function call is expensive. Don't call it often.
    */

  def handlerBehaviorChanged(callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = {
    bindings.WebRequest.handlerBehaviorChanged(callback)
  }

  /**
    * Fired when a request is about to occur.
    */
  var onBeforeRequest: WebRequestEventSource[BlockableCallback[WebRequestBodyDetails]] = {
    bindings.WebRequest.onBeforeRequest
  }

  /**
    * Fired before sending an HTTP request, once the request headers are available. This may occur after a TCP
    * connection is made to the server, but before any HTTP data is sent.
    */
  var onBeforeSendHeaders: WebRequestEventSource[BlockableCallback[WebRequestDetails]] = {
    bindings.WebRequest.onBeforeSendHeaders
  }

  /**
    * Fired just before a request is going to be sent to the server (modifications of previous onBeforeSendHeaders
    * callbacks are visible by the time onSendHeaders is fired).
    */
  var onSendHeaders: WebRequestEventSource[Callback[WebRequestHeadersDetails]] = {
    bindings.WebRequest.onSendHeaders
  }

  /**
    * Fired when HTTP response headers of a request have been received.
    */
  val onHeadersReceived: WebRequestEventSource[BlockableCallback[WebResponseHeadersDetails]] = {
    bindings.WebRequest.onHeadersReceived
  }

  /**
    * Fired when an authentication failure is received. The listener has three options: it can provide authentication
    * credentials, it can cancel the request and display the error page, or it can take no action on the challenge. If
    * bad user credentials are provided, this may be called multiple times for the same request.
    */
  var onAuthRequired: WebRequestEventSource[BlockableAuthCallback[WebAuthenticationChallengeDetails]] = {
    bindings.WebRequest.onAuthRequired
  }

  /**
    * Fired when the first byte of the response body is received. For HTTP requests, this means that the status line
    * and response headers are available.
    */
  var onResponseStarted: WebRequestEventSource[Callback[WebResponseCacheDetails]] = {
    bindings.WebRequest.onResponseStarted
  }

  /**
    * Fired when a server-initiated redirect is about to occur.
    */
  var onBeforeRedirect: WebRequestEventSource[Callback[WebRedirectionResponseDetails]] = {
    bindings.WebRequest.onBeforeRedirect
  }

  /**
    * Fired when a request is completed.
    */
  var onCompleted: WebRequestEventSource[Callback[WebResponseCacheDetails]] = {
    bindings.WebRequest.onCompleted
  }

  /**
    * Fired when an error occurs.
    */
  var onErrorOccurred: WebRequestEventSource[Callback[WebResponseErrorDetails]] = {
    bindings.WebRequest.onErrorOccurred
  }
}