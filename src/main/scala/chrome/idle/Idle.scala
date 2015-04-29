package chrome.idle

import chrome.events.EventSource
import chrome.events.EventSourceImplicits._
import bindings._

import scala.concurrent.{Promise, Future}

object Idle {
  val onStateChanged: EventSource[State] = bindings.Idle.onStateChanged

  def queryState(detectionIntervalInSeconds: Int): Future[State] = {
    val promise = Promise[State]()
    bindings.Idle.queryState(detectionIntervalInSeconds, (state: State) => {
      promise.complete(chrome.lastErrorOrValue(state))
    })
    promise.future
  }

  def setDetectionInterval(intervalInSeconds: Int): Unit = bindings.Idle.setDetectionInterval(intervalInSeconds)
}
