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

  val enqueue: js.UndefOr[Boolean] = js.native
  val voiceName: js.UndefOr[String] = js.native
  val extensionId: js.UndefOr[String] = js.native
  val lang: js.UndefOr[String] = js.native
  val gender: js.UndefOr[TTSVoice.Gender] = js.native
  val rate: js.UndefOr[Double] = js.native
  val pitch: js.UndefOr[Double] = js.native
  val volume: js.UndefOr[Double] = js.native
  val requiredEventTypes: js.UndefOr[TTSEvent.Type] = js.native
  val desiredEventTypes: js.UndefOr[TTSEvent.Type] = js.native
  val onEvent: js.UndefOr[String] = js.native

}
