package chrome.app.window.bindings

import scala.scalajs.js


class FrameOptions extends js.Object {

   def `type`: js.UndefOr[FrameOptions.Type] = js.native
   def color: js.UndefOr[String] = js.native
   def activeColor: js.UndefOr[String] = js.native
   def inactiveColor: js.UndefOr[String] = js.native

 }

object FrameOptions {

  type Type = String

  val NONE: Type = "none"
  val CHROME: Type = "chrome"

}