package chrome.tabs.bindings

import scala.scalajs.js

object CaptureOptions {

  type ImageFormat = String

  val JPEG: ImageFormat = "jpeg"
  val PNG: ImageFormat = "png"

}

@js.native
trait CaptureOptions extends js.Object {

  def format: js.UndefOr[CaptureOptions.ImageFormat] = js.native

  def quality: js.UndefOr[Int] = js.native

}
