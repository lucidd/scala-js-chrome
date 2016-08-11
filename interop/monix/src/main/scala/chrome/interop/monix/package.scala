package chrome.interop

import _root_.monix.reactive._
import _root_.monix.execution._
import chrome.events.bindings.Event

import scala.scalajs.js

package object monix {

  implicit class Event0MonixOps(val event: Event[js.Function0[_]]) extends AnyVal {
    def toObservable(strategy: OverflowStrategy.Synchronous[Unit]): Observable[Unit] =
      Observable.create(strategy){ sub =>
        val fn = () => sub.onNext(())
        event.addListener(fn)
        Cancelable.apply(() => event.removeListener(fn))
      }
  }

  implicit class Event1MonixOps[T1](val event: Event[js.Function1[T1, _]]) extends AnyVal {
    def toObservable(strategy: OverflowStrategy.Synchronous[T1]): Observable[T1] =
      Observable.create(strategy){ sub =>
        val fn = (t1: T1) => sub.onNext(t1)
        event.addListener(fn)
        Cancelable.apply(() => event.removeListener(fn))
      }
  }

  implicit class Event2MonixOps[T1, T2](val event: Event[js.Function2[T1, T2, _]]) extends AnyVal {
    def toObservable(strategy: OverflowStrategy.Synchronous[(T1, T2)]): Observable[(T1, T2)] =
      Observable.create(strategy){ sub =>
        val fn = (t1: T1, t2: T2) => sub.onNext((t1, t2))
        event.addListener(fn)
        Cancelable.apply(() => event.removeListener(fn))
      }
  }

  implicit class Event3MonixOps[T1, T2, T3](val event: Event[js.Function3[T1, T2, T3, _]]) extends AnyVal {
    def toObservable(strategy: OverflowStrategy.Synchronous[(T1, T2, T3)]): Observable[(T1, T2, T3)] =
      Observable.create(strategy){ sub =>
        val fn = (t1: T1, t2: T2, t3: T3) => sub.onNext((t1, t2, t3))
        event.addListener(fn)
        Cancelable.apply(() => event.removeListener(fn))
      }
  }


}
