package chrome.interop

import _root_.fs2._
import _root_.fs2.util._
import _root_.fs2.util.syntax._
import _root_.fs2.async.mutable.Queue
import chrome.events.bindings.Event

import scala.language.higherKinds

import scala.scalajs.js

package object fs2 {

  implicit class Event1FS2Ops[T1](val event: Event[js.Function1[T1, _]])
      extends AnyVal {

    def single[F[_]: Async: Suspendable]: F[T1] =
      Async[F].async[T1] { callback =>
        Suspendable[F].delay {
          var fn = (t: T1) => ()
          fn = t => {
            event.removeListener(fn)
            callback(Right(t))
          }
          event.addListener(fn)
        }
      }

    def toStream[F[_]: Async]: Stream[F, T1] =
      toStream(async.unboundedQueue[F, T1])

    def toStream[F[_]: Async](queue: F[Queue[F, T1]]): Stream[F, T1] = {
      Stream.bracket{
        queue.map { q =>
          val callback = (t: T1) => q.offer1(t).unsafeRunAsync(_ => ())
          event.addListener(callback)
          val release = Suspendable[F].delay(event.removeListener(callback))
          (q, release)
        }
      }(_._1.dequeue, _._2)
    }

  }

  implicit class Event2FS2Ops[T1, T2](val event: Event[js.Function2[T1, T2, _]])
    extends AnyVal {

    def single[F[_]: Async: Suspendable]: F[(T1, T2)] =
      Async[F].async[(T1, T2)] { callback =>
        Suspendable[F].delay {
          var fn = (t1: T1, t2: T2) => ()
          fn = (t1, t2) => {
            event.removeListener(fn)
            callback(Right((t1, t2)))
          }
          event.addListener(fn)
        }
      }

    def toStream[F[_]: Async]: Stream[F, (T1, T2)] =
      toStream(async.unboundedQueue[F, (T1, T2)])

    def toStream[F[_]: Async](queue: F[Queue[F, (T1, T2)]]): Stream[F, (T1, T2)] = {
      Stream.bracket{
        queue.map { q =>
          val callback = (t1: T1, t2: T2) => q.offer1((t1, t2)).unsafeRunAsync(_ => ())
          event.addListener(callback)
          val release = Suspendable[F].delay(event.removeListener(callback))
          (q, release)
        }
      }(_._1.dequeue, _._2)
    }

  }

  implicit class Event3FS2Ops[T1, T2, T3](val event: Event[js.Function3[T1, T2, T3, _]])
    extends AnyVal {

    def single[F[_]: Async: Suspendable]: F[(T1, T2, T3)] =
      Async[F].async[(T1, T2, T3)] { callback =>
        Suspendable[F].delay {
          var fn = (t1: T1, t2: T2, t3: T3) => ()
          fn = (t1, t2, t3) => {
            event.removeListener(fn)
            callback(Right((t1, t2, t3)))
          }
          event.addListener(fn)
        }
      }

    def toStream[F[_]: Async]: Stream[F, (T1, T2, T3)] =
      toStream(async.unboundedQueue[F, (T1, T2, T3)])

    def toStream[F[_]: Async](queue: F[Queue[F, (T1, T2, T3)]]): Stream[F, (T1, T2, T3)] = {
      Stream.bracket{
        queue.map { q =>
          val callback = (t1: T1, t2: T2, t3: T3) => q.offer1((t1, t2, t3)).unsafeRunAsync(_ => ())
          event.addListener(callback)
          val release = Suspendable[F].delay(event.removeListener(callback))
          (q, release)
        }
      }(_._1.dequeue, _._2)
    }

  }


}
