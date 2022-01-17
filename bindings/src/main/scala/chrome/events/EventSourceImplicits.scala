package chrome.events

import chrome.events.bindings.Event

import scala.scalajs.js

class EventSource0Impl(event: Event[js.Function0[_]]) extends EventSource[Unit] {

  class SubscriptionImpl(fn: Unit => Unit) extends Subscription {

    val fn2 = js.Any.fromFunction0(() => fn(()))

    event.addListener(fn2)

    def cancel(): Unit = {
      event.removeListener(fn2)
    }

  }

  def listen(fn: Unit => Unit): Subscription = {
    new SubscriptionImpl(fn)
  }

}

class EventSource1Impl[A](event: Event[js.Function1[A, _]]) extends EventSource[A] {

  class SubscriptionImpl(fn: A => Unit) extends Subscription {

    event.addListener(fn)

    def cancel(): Unit = {
      event.removeListener(fn)
    }

  }

  def listen(fn: A => Unit): Subscription = {
    new SubscriptionImpl(fn)
  }

}

class EventSource2Impl[A, B](event: Event[js.Function2[A, B, _]]) extends EventSource[(A, B)] {

  class SubscriptionImpl(fn: ((A, B)) => Unit) extends Subscription {

    val untupled = Function.untupled(fn)

    event.addListener(untupled)

    def cancel(): Unit = {
      event.removeListener(untupled)
    }

  }

  def listen(fn: ((A, B)) => Unit): Subscription = {
    new SubscriptionImpl(fn)
  }

}

class EventSource3Impl[A, B, C](event: Event[js.Function3[A, B, C, _]]) extends EventSource[(A, B, C)] {

  class SubscriptionImpl(fn: ((A, B, C)) => Unit) extends Subscription {

    val untupled = Function.untupled(fn)

    event.addListener(untupled)

    def cancel(): Unit = {
      event.removeListener(untupled)
    }

  }

  def listen(fn: ((A, B, C)) => Unit): Subscription = {
    new SubscriptionImpl(fn)
  }

}

object EventSourceImplicits {

  implicit def eventAsEventSource0(event: Event[js.Function0[_]]): EventSource[Unit] =
    new EventSource0Impl(event)

  implicit def eventAsEventSource1[A](event: Event[js.Function1[A, _]]): EventSource[A] =
    new EventSource1Impl(event)

  implicit def eventAsEventSource2[A, B](event: Event[js.Function2[A, B, _]]): EventSource[(A, B)] =
    new EventSource2Impl(event)

  implicit def eventAsEventSource3[A, B, C](event: Event[js.Function3[A, B, C, _]]): EventSource[(A, B, C)] =
    new EventSource3Impl(event)

}
