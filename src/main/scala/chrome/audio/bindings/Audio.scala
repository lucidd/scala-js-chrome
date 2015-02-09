package chrome.audio.bindings

import chrome.events.bindings.Event

import scala.scalajs.js.annotation.JSName

import scala.scalajs.js


@JSName("chrome.audio")
object Audio extends js.Object {
  
  type DeviceID = String

  def getInfo(callback: js.Function2[js.Array[OutputInfo], js.Array[InputInfo], _]): Unit = js.native
  def setActiveDevice(ids: js.Array[DeviceID], callback: js.Function0[_]): Unit = js.native
  def setProperties(id: DeviceID, properties: Properties, callback: js.Function0[_]): Unit = js.native
  
  val onDeviceChanged: Event[js.Function0[_]] = js.native

}







