package chrome.idle

import chrome.ChromeAPI
import chrome.events.EventSource
import chrome.events.EventSourceImplicits._
import utils.ErrorHandling.lastErrorOrValue
import bindings._
import chrome.permissions.APIPermission

import scala.concurrent.{Promise, Future}

object Idle extends ChromeAPI {

  val requiredPermissions: Set[APIPermission] = Set(APIPermission.Idle)

  val onStateChanged: EventSource[State] = bindings.Idle.onStateChanged

  def queryState(detectionIntervalInSeconds: Int): Future[State] = {
    val promise = Promise[State]()
    bindings.Idle.queryState(detectionIntervalInSeconds, (state: State) => {
      promise.complete(lastErrorOrValue(state))
    })
    promise.future
  }

  def setDetectionInterval(intervalInSeconds: Int): Unit = bindings.Idle.setDetectionInterval(intervalInSeconds)
}
