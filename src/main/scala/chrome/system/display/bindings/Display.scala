package chrome.system.display.bindings

import chrome.events.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@JSName("chrome.system.display")
object Display extends js.Object {

  type ID = String

  def getInfo(callback: js.Function1[js.Array[DisplayInfo], _]) = js.native
  def setDisplayProperties(id: ID, info: DisplayProperties, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native

  val onDisplayChanged: Event[js.Function0[_]] = js.native

}












