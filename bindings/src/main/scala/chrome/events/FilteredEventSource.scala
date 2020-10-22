package chrome.events

class FilteredEventSource[A](source: EventSource[A], filter: A => Boolean) extends EventSource[A] {

  def listen(fn: A => Unit): Subscription = {
    source.listen((event) => {
      if (filter(event)) fn(event)
    })
  }

}
