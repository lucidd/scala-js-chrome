package chrome.tts

import chrome.ChromeAPI
import chrome.permissions.Permission.API
import chrome.tts.bindings._
import chrome.utils.ErrorHandling._

import scala.concurrent.{Future, Promise}
import scala.scalajs.js

object TTS extends ChromeAPI {

  val requiredPermissions: Set[API] = Set(API.TTS)

  def speak(utterance: String,
            options: js.UndefOr[SpeakOptions] = js.undefined): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.TTS.speak(utterance, options, js.Any.fromFunction0(() => {
      promise.complete(lastErrorOrValue(()))
    }))
    promise.future
  }

  def stop(): Unit = bindings.TTS.stop()

  def pause(): Unit = bindings.TTS.pause()

  def resume(): Unit = bindings.TTS.resume()

  def isSpeaking: Future[Boolean] = {
    val promise = Promise[Boolean]()
    bindings.TTS.isSpeaking(js.Any.fromFunction1((speaking: Boolean) => {
      promise.complete(lastErrorOrValue(speaking))
    }))
    promise.future
  }

  def getVoices: Future[js.Array[TTSVoice]] = {
    val promise = Promise[js.Array[TTSVoice]]()
    bindings.TTS.getVoices(
        js.Any.fromFunction1((voices: js.Array[TTSVoice]) => {
      promise.complete(lastErrorOrValue(voices))
    }))
    promise.future
  }

}
