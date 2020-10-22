package chrome.tts.bindings

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.{UndefOr, native, undefined}

@js.native
@JSGlobal("chrome.tts")
object TTS extends js.Object {

  def speak(
      utterance: String,
      options: UndefOr[SpeakOptions] = undefined,
      callback: UndefOr[js.Function0[_]] = undefined
  ): Unit = native

  def stop(): Unit = native

  def pause(): Unit = native

  def resume(): Unit = native

  def isSpeaking(callback: UndefOr[js.Function1[Boolean, _]] = undefined): Unit = native

  def getVoices(callback: UndefOr[js.Function1[js.Array[TTSVoice], _]] = undefined): Unit = native

}
