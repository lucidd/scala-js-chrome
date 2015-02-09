package chrome.system.display

import bindings._
import chrome.events.bindings.Event

import scala.concurrent.{Promise, Future}
import scala.scalajs.js


object Display {

  def getInfo: Future[List[DisplayInfo]] = {
    val promise = Promise[List[DisplayInfo]]
    bindings.Display.getInfo((info: js.Array[DisplayInfo]) => {
      promise.complete(chrome.lastErrorOrValue(info.toList))
    })
    promise.future
  }
  
  def setDisplayProperties(id: bindings.Display.ID, info: DisplayProperties): Future[bindings.Display.ID] = {
    val promise = Promise[bindings.Display.ID]
    bindings.Display.setDisplayProperties(id, info, js.Any.fromFunction0(() => {
      promise.complete(chrome.lastErrorOrValue(id))
    }))
    promise.future
  }

  val onDisplayChanged: Event[js.Function0[_]] = bindings.Display.onDisplayChanged

}
