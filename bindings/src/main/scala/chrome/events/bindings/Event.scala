package chrome.events.bindings

import scala.scalajs.js



@js.native
trait Event[-T <: js.Function] extends js.Object {

  def addListener(callback: T): Unit = js.native
  def removeListener(callback: T): Unit = js.native
  def hasListener(callback: T): Boolean = js.native
  def hasListeners(): Boolean = js.native

}
