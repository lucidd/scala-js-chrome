package chrome.commands.bindings

import chrome.events.bindings.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
@JSName("chrome.commands")
object Commands extends js.Object {

  val onCommand: Event[js.Function1[String, _]] = js.native

  def getAll(callback: js.UndefOr[js.Function1[js.Array[Command], _]] = js.undefined): Unit = js.native

}
