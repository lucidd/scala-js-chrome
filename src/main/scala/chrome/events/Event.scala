package chrome.events

import scala.scalajs.js


class Event[T <: js.Function] extends js.Object {

  def addListener(callback: T): Unit  = js.native

}
