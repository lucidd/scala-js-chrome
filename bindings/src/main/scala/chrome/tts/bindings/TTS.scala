package chrome.tts.bindings

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.{UndefOr, undefined}

@js.native
@JSGlobal("chrome.tts")
object TTS extends js.Object {

  def speak(
      utterance: String,
      options: UndefOr[SpeakOptions] = undefined,
      callback: UndefOr[js.Function0[_]] = undefined
  ): Unit = js.native

  def stop(): Unit = js.native

  def pause(): Unit = js.native

  def resume(): Unit = js.native

  def isSpeaking(callback: UndefOr[js.Function1[Boolean, _]] = undefined): Unit = js.native

  def getVoices(callback: UndefOr[js.Function1[js.Array[TTSVoice], _]] = undefined): Unit = js.native

}
