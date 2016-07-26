package chrome.audio.bindings

import chrome.events.bindings.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
@JSName("chrome.audio")
object Audio extends js.Object {

  type DeviceID = String
  val onDeviceChanged: Event[js.Function0[_]] = js.native

  def getInfo(
      callback: js.Function2[js.Array[OutputInfo], js.Array[InputInfo], _])
    : Unit = js.native

  def setActiveDevice(ids: js.Array[DeviceID],
                      callback: js.Function0[_]): Unit = js.native

  def setProperties(id: DeviceID,
                    properties: Properties,
                    callback: js.Function0[_]): Unit = js.native

}
