package chrome.system.display.bindings

import chrome.events.bindings.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.{UndefOr, undefined}

@js.native
@JSGlobal("chrome.system.display")
object Display extends js.Object {

  type ID = String
  val onDisplayChanged: Event[js.Function0[_]] = js.native

  def getInfo(callback: js.Function1[js.Array[DisplayInfo], _]): Unit = js.native

  def setDisplayProperties(id: ID, info: DisplayProperties, callback: UndefOr[js.Function0[_]] = undefined): Unit =
    js.native

}
