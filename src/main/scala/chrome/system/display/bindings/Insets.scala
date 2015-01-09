package chrome.system.display.bindings

import scala.scalajs.js


class Insets extends js.Object {

  val left: Int = js.native
  val top: Int = js.native
  val right: Int = js.native
  val bottom: Int = js.native

}

object Insets {

  def apply(left: Int, top: Int, right: Int, bottom: Int): Insets = {
    js.Dynamic.literal(
      left = left,
      top = top,
      right = right,
      bottom = bottom
    ).asInstanceOf[Insets]
  }

}
