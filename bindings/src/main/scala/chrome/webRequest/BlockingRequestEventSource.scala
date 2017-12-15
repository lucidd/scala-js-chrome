package chrome.webRequest

import chrome.events._
import chrome.webRequest.bindings._

import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.UndefOr

trait WebRequestEventSource[T <: js.Function] {
  def listen(callback: T,
             filter: RequestFilter,
             opt_extraInfoSpec: js.UndefOr[js.Array[String]] = js.undefined): Subscription
}

private[webRequest] class SubscriptionImpl[A <: js.Function](event: WebRequestEvent[A], fn: A) extends Subscription {
  override def cancel(): Unit = event.removeListener(fn)
}

class WebRequestEventSourceImpl[T <: js.Function](event: WebRequestEvent[T])
  extends WebRequestEventSource[T] {

  override def listen(callback: T,
                      filter: RequestFilter,
                      opt_extraInfoSpec: UndefOr[js.Array[String]] = js.undefined): Subscription = {
    event.addListener(callback, filter, opt_extraInfoSpec)

    new SubscriptionImpl(event, callback)
  }
}


object WebRequestEventSource {
  implicit def eventAsEventSource[T <: js.Function](event: WebRequestEvent[T]): WebRequestEventSource[T] =
    new WebRequestEventSourceImpl(event)
}