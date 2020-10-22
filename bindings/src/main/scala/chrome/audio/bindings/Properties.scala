package chrome.audio.bindings

import scala.scalajs.js

object Properties {

  def apply(
      isMuted: Boolean,
      volume: js.UndefOr[Double] = js.undefined,
      gain: js.UndefOr[Double] = js.undefined
  ): Properties = {
    js.Dynamic
      .literal(
        isMuted = isMuted,
        volume = volume,
        gain = gain
      )
      .asInstanceOf[Properties]
  }

}

@js.native
trait Properties extends js.Object {

  def isMuted: Boolean = js.native

  def volume: js.UndefOr[Double] = js.native

  def gain: js.UndefOr[Double] = js.native

}
