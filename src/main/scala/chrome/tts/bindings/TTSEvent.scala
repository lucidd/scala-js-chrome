package chrome.tts.bindings

import scala.scalajs.js

object TTSEvent {

  type Type = String

  object Types {

    val START: Type = "start"
    val END: Type = "end"
    val WORD: Type = "word"
    val SENTENCE: Type = "sentence"
    val MARKER: Type = "marker"
    val INTERRUPTED: Type = "interrupted"
    val CANCELLED: Type = "cancelled"
    val ERROR: Type = "error"
    val PAUSE: Type = "pause"
    val RESUME: Type = "resume"

  }

}

class TTSEvent extends js.Object {

  val `type`: TTSEvent.Type = js.native
  def charIndex: js.UndefOr[Double] = js.native
  def errorMessage: js.UndefOr[String] = js.native

}