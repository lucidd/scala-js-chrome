package chrome.runtime.bindings

import chrome.events.Event

import scala.scalajs.js

class Port extends js.Object {

  val name: String = js.native
  def disconnect(): Unit = js.native
  val onDisconnect: Event[js.Function0[_]] = js.native
  //TODO: find out how the callback function for onMessage looks
  val onMessage: Event[js.Function1[js.Object, _]] = js.native
  def postMessage(): Unit = js.native
  def sender: js.UndefOr[MessageSender] = js.native

}
