package chrome.omnibox.bindings

import chrome.events.bindings.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@JSName("chrome.omnibox")
object Omnibox extends js.Object {

  val onInputStarted: Event[js.Function0[_]] = js.native
  val onInputChanged: Event[js.Function2[String, js.Function1[js.Array[SuggestResult], _], _]] = js.native
  val onInputEntered: Event[js.Function2[String, OnInputEnteredDisposition, _]] = js.native
  val onInputCancelled: Event[js.Function0[_]] = js.native

  def setDefaultSuggestion(suggestion: DefaultSuggestion): Unit = js.native

}
