package chrome.audio

import chrome.audio.bindings._
import chrome.events.bindings.Event

import scala.concurrent.{Future, Promise}
import scala.scalajs.js

object Audio {

  val onDeviceChanged: Event[js.Function0[_]] = bindings.Audio.onDeviceChanged

  def getInfo: Future[(js.Array[OutputInfo], js.Array[InputInfo])] = {
    val promise = Promise[(js.Array[OutputInfo], js.Array[InputInfo])]()
    bindings.Audio.getInfo((outoutInfo: js.Array[OutputInfo], inputInfo: js.Array[InputInfo]) => {
      promise.complete(chrome.lastErrorOrValue((outoutInfo, inputInfo)))
    })
    promise.future
  }

  def setActiveDevice(ids: js.Array[bindings.Audio.DeviceID]): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.Audio.setActiveDevice(ids, () => {
      promise.complete(chrome.lastErrorOrValue(()))
    })
    promise.future
  }

  def setProperties(id: bindings.Audio.DeviceID, properties: Properties): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.Audio.setProperties(id, properties, () => {
      promise.complete(chrome.lastErrorOrValue(()))
    })
    promise.future
  }

}
