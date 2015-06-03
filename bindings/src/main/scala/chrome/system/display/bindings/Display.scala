package chrome.system.display.bindings

import chrome.events.bindings.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.{UndefOr, native, undefined}

@JSName("chrome.system.display")
object Display extends js.Object {

  type ID = String
  val onDisplayChanged: Event[js.Function0[_]] = native

  def getInfo(callback: js.Function1[js.Array[DisplayInfo], _]): Unit = native

  def setDisplayProperties(id: ID, info: DisplayProperties,
                           callback: UndefOr[js.Function0[_]] = undefined): Unit = native

}












