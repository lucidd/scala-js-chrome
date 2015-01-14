package chrome.tts.bindings

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@JSName("chrome.tts")
object TTS extends js.Object {

  def speak(utterance: String, options: js.UndefOr[SpeakOptions] = js.undefined, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native
  def stop(): Unit = js.native
  def pause(): Unit = js.native
  def resume(): Unit = js.native
  def isSpeaking(callback: js.UndefOr[js.Function1[Boolean, _]] = js.undefined): Unit = js.native
  def getVoices(callback: js.UndefOr[js.Function1[js.Array[TTSVoice], _]] = js.undefined): Unit = js.native

}












