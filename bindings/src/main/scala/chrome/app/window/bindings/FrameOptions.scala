package chrome.app.window.bindings

import scala.scalajs.js


class FrameOptions extends js.Object {

  val `type`: js.UndefOr[FrameOptions.Type] = js.native
  val color: js.UndefOr[String] = js.native
  val activeColor: js.UndefOr[String] = js.native
  val inactiveColor: js.UndefOr[String] = js.native

}

object FrameOptions {

  type Type = String

  val NONE: Type = "none"
  val CHROME: Type = "chrome"

}
