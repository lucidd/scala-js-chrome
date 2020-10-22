package chrome.system.display.bindings

import scala.scalajs.js

@js.native
trait Bounds extends js.Object {

  val left: Int = js.native
  val top: Int = js.native
  val width: Int = js.native
  val height: Int = js.native

}

object Bounds {

  def apply(left: Int, top: Int, width: Int, height: Int): Bounds = {
    js.Dynamic
      .literal(
        left = left,
        top = top,
        width = width,
        height = height
      )
      .asInstanceOf[Bounds]
  }

}
