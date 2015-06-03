package chrome.app.runtime.bindings

import chrome.events.bindings.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@JSName("chrome.app.runtime")
object Runtime extends js.Object {

  val onEmbedRequested: Event[js.Function1[Request, _]] = js.native
  val onLaunched: Event[js.Function1[LaunchData, _]] = js.native
  val onRestarted: Event[js.Function0[_]] = js.native

}






