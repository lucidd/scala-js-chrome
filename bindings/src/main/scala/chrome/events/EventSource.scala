package chrome.events

import scala.collection.mutable


trait Subscription {
  def cancel(): Unit
}

trait EventSource[+A] {

  def listen(fn: A => Unit): Subscription

  def map[B](fn: A => B): EventSource[B] = {
    new MappedEventSource[A, B](this, fn)
  }

  def filter(fn: A => Boolean): EventSource[A] = {
    new FilteredEventSource[A](this, fn)
  }

  def merge[B <: C, C >: A](other: EventSource[B]): EventSource[C] = {
    val source = new EventSourceController[C]()
    listen(source.emit)
    other.listen(source.emit)
    source
  }

}

class EventSourceController[A] extends EventSource[A] {

  val subcribers = new mutable.ListBuffer[A => Unit]

  def listen(fn: A => Unit): Subscription = {
    subcribers += fn
    new Subscription {
      override def cancel(): Unit = {
        subcribers -= fn
      }
    }
  }

  def emit(value: A): Unit = {
    subcribers.foreach( fn =>
      scala.scalajs.concurrent.JSExecutionContext.queue.execute(new Runnable {
        override def run(): Unit = fn(value)
      })
    )
  }

  def source: EventSource[A] = this

}
