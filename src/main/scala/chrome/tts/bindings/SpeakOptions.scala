package chrome.tts.bindings

import scala.scalajs.js

object SpeakOptions {

  def apply(enqueue: js.UndefOr[Boolean] = js.undefined,
            voiceName: js.UndefOr[String] = js.undefined,
            extensionId: js.UndefOr[String] = js.undefined,
            lang: js.UndefOr[String] = js.undefined,
            gender: js.UndefOr[TTSVoice.Gender] = js.undefined,
            rate: js.UndefOr[Double] = js.undefined,
            pitch: js.UndefOr[Double] = js.undefined,
            volume: js.UndefOr[Double] = js.undefined,
            requiredEventTypes: js.UndefOr[TTSEvent.Type] = js.undefined,
            desiredEventTypes: js.UndefOr[TTSEvent.Type] = js.undefined,
            onEvent: js.UndefOr[String] = js.undefined): SpeakOptions = {
    js.Dynamic.literal(
        enqueue = enqueue,
        voiceName = voiceName,
        extensionId = extensionId,
        lang = lang,
        gender = gender,
        rate = rate,
        pitch = pitch,
        volume = volume,
        requiredEventTypes = requiredEventTypes,
        desiredEventTypes = desiredEventTypes,
        onEvent = onEvent
    ).asInstanceOf[SpeakOptions]
  }

}

class SpeakOptions extends js.Object {

  def enqueue: js.UndefOr[Boolean] = js.native
  def voiceName: js.UndefOr[String] = js.native
  def extensionId: js.UndefOr[String] = js.native
  def lang: js.UndefOr[String] = js.native
  def gender: js.UndefOr[TTSVoice.Gender] = js.native
  def rate: js.UndefOr[Double] = js.native
  def pitch: js.UndefOr[Double] = js.native
  def volume: js.UndefOr[Double] = js.native
  def requiredEventTypes: js.UndefOr[TTSEvent.Type] = js.native
  def desiredEventTypes: js.UndefOr[TTSEvent.Type] = js.native
  def onEvent: js.UndefOr[String] = js.native

}