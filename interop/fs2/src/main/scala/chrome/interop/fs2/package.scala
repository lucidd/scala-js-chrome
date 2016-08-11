package chrome.interop

import _root_.fs2._
import _root_.fs2.util._
import chrome.events.bindings.Event

import scala.scalajs.js

package object fs2 {

  implicit class Event1FS2Ops[T1](val event: Event[js.Function1[T1, _]]) extends AnyVal {

    def toTask(implicit strategy: Strategy): Task[T1] = {
      Task.async[T1] { register =>
        var fn = (t: T1) => ()
        fn = t => {
          event.removeListener(fn)
          register(Right(t))
        }
        event.addListener(fn)
      }
    }



    def toStream(implicit strategy: Strategy): Stream[Task, T1] = Stream.repeatEval(toTask)

  }

}
