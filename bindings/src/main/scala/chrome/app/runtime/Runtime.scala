package chrome.app.runtime

import chrome.app.runtime.bindings.{LaunchData, Request}
import chrome.events.EventSource
import chrome.events.EventSourceImplicits._

object Runtime {

  val onEmbedRequested: EventSource[Request] = bindings.Runtime.onEmbedRequested
  val onLaunched: EventSource[LaunchData] = bindings.Runtime.onLaunched
  val onRestarted: EventSource[Unit] = bindings.Runtime.onRestarted

}
