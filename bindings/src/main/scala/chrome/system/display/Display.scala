package chrome.system.display

import chrome.ChromeAPI
import chrome.events.EventSource
import chrome.events.EventSourceImplicits._
import chrome.permissions.APIPermission
import chrome.system.display.bindings._

import scala.concurrent.{Future, Promise}
import scala.scalajs.js


object Display extends ChromeAPI {

  val requiredPermissions: Set[APIPermission] = Set(APIPermission.System.Display)

  val onDisplayChanged: EventSource[Unit] = bindings.Display.onDisplayChanged

  def getInfo: Future[List[DisplayInfo]] = {
    val promise = Promise[List[DisplayInfo]]()
    bindings.Display.getInfo((info: js.Array[DisplayInfo]) => {
      promise.complete(chrome.lastErrorOrValue(info.toList))
    })
    promise.future
  }

  def setDisplayProperties(id: bindings.Display.ID, info: DisplayProperties): Future[bindings.Display.ID] = {
    val promise = Promise[bindings.Display.ID]()
    bindings.Display.setDisplayProperties(id, info, js.Any.fromFunction0(() => {
      promise.complete(chrome.lastErrorOrValue(id))
    }))
    promise.future
  }

}
