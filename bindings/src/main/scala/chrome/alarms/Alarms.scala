package chrome.alarms

import chrome.alarms.bindings.{AlarmInfo, Alarm}
import chrome.events.EventSource
import chrome.events.EventSourceImplicits._
import chrome.utils.ErrorHandling._

import scala.concurrent.{Future, Promise}
import scala.scalajs.js

object Alarms {

  val onAlarm: EventSource[Alarm] = bindings.Alarms.onAlarm

  def getAll(): Future[List[Alarm]] = {
    val promise = Promise[List[Alarm]]()
    bindings.Alarms.getAll((alarms: js.Array[bindings.Alarm]) => {
      promise.complete(lastErrorOrValue(alarms.toList))
    })
    promise.future
  }

  def clearAll(): Future[Boolean] = {
    val promise = Promise[Boolean]()
    bindings.Alarms.clearAll(js.Any.fromFunction1((wasCleared: Boolean) => {
      promise.complete(lastErrorOrValue(wasCleared))
    }))
    promise.future
  }

  def create(name: String = "", alarmInfo: AlarmInfo): Unit = {
    bindings.Alarms.create(name, alarmInfo)
  }

  def get(name: String): Future[Option[Alarm]] = {
    val promise = Promise[Option[Alarm]]
    bindings.Alarms.get(name, (alarm: js.UndefOr[Alarm]) => {
      promise.complete(lastErrorOrValue(alarm.toOption))
    })
    promise.future
  }

  def clear(name: String = ""): Future[Boolean] = {
    val promise = Promise[Boolean]()
    bindings.Alarms.clear(name, js.Any.fromFunction1((wasCleared: Boolean) => {
      promise.complete(lastErrorOrValue(wasCleared))
    }))
    promise.future
  }

}
