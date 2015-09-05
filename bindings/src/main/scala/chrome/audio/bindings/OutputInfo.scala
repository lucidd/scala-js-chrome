package chrome.audio.bindings

import scala.scalajs.js

@js.native
trait OutputInfo extends js.Object {

  def id: Audio.DeviceID = js.native

  def name: String = js.native

  def isActive: Boolean = js.native

  def isMuted: Boolean = js.native

  def volume: Double = js.native

}
