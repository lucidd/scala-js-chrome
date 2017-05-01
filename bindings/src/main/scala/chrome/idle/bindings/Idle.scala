package chrome.idle.bindings

import chrome.events.bindings.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal("chrome.idle")
object Idle extends js.Object {

  val onStateChanged: Event[js.Function1[State, _]] = js.native

  def queryState(detectionIntervalInSeconds: Int,
                 callback: js.Function1[State, _]): Unit = js.native

  def setDetectionInterval(intervalInSeconds: Int): Unit = js.native

}
