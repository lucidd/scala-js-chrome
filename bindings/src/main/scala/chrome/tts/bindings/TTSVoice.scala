package chrome.tts.bindings

import scala.scalajs.js

object TTSVoice {

  type Gender = String

  object Genders {
    val MALE: Gender = "male"
    val FEMALE: Gender = "female"
  }

}

@js.native
trait TTSVoice extends js.Object {

  def voiceName: js.UndefOr[String] = js.native

  def lang: js.UndefOr[String] = js.native

  def gender: js.UndefOr[TTSVoice.Gender] = js.native

  def remote: js.UndefOr[Boolean] = js.native

  def extensionId: js.UndefOr[String] = js.native

  def eventTypes: js.UndefOr[js.Array[TTSEvent.Type]] = js.native

}
