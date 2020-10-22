package chrome.omnibox

import chrome.events.EventSource
import chrome.events.EventSourceImplicits._
import chrome.omnibox.bindings.OnInputEnteredDisposition

import scala.scalajs.js
import bindings._

object Omnibox {

  val onInputStarted: EventSource[Unit] = bindings.Omnibox.onInputStarted

  val onInputChanged: EventSource[(String, js.Function1[js.Array[SuggestResult], _])] =
    bindings.Omnibox.onInputChanged

  val onInputEntered: EventSource[(String, OnInputEnteredDisposition)] =
    bindings.Omnibox.onInputEntered
  val onInputCancelled: EventSource[Unit] = bindings.Omnibox.onInputCancelled

  def setDefaultSuggestion(suggestion: DefaultSuggestion): Unit =
    bindings.Omnibox.setDefaultSuggestion(suggestion)

}
