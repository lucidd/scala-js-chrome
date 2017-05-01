package chrome.alarms.bindings

import chrome.events.bindings.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal("chrome.alarms")
object Alarms extends js.Object {

  val onAlarm: Event[js.Function1[Alarm, _]] = js.native

  def create(name: String = "", alarmInfo: AlarmInfo): Unit = js.native

  def get(name: String = "",
          callback: js.Function1[js.UndefOr[Alarm], _]): Unit = js.native

  def getAll(callback: js.Function1[js.Array[Alarm], _]): Unit = js.native

  def clear(
      name: String = "",
      callback: js.UndefOr[js.Function1[Boolean, _]] = js.undefined): Unit =
    js.native

  def clearAll(
      callback: js.UndefOr[js.Function1[Boolean, _]] = js.undefined): Unit =
    js.native

}
