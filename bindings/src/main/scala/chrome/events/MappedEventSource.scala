package chrome.events

class MappedEventSource[A, B](source: EventSource[A], map: A => B)
    extends EventSource[B] {

  def listen(fn: B => Unit): Subscription = {
    source.listen(map.andThen(fn))
  }

}
