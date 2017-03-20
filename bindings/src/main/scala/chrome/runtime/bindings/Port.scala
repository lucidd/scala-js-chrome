package chrome.runtime.bindings

import chrome.events.bindings.Event

import scala.scalajs.js

@js.native
trait Port extends js.Object {

  val name: String = js.native
  val onDisconnect: Event[js.Function0[_]] = js.native
  //TODO: find out how the callback function for onMessage looks
  val onMessage: Event[js.Function2[js.Any, MessageSender, _]] = js.native

  def disconnect(): Unit = js.native

  def postMessage(message: js.Any): Unit = js.native

  def sender: js.UndefOr[MessageSender] = js.native

}
