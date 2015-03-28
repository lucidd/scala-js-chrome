package chrome.app.window.bindings

import scala.scalajs.js

object BoundsSpecification {

  def apply(
             left: js.UndefOr[Int] = js.undefined,
             top: js.UndefOr[Int] = js.undefined,
             width: js.UndefOr[Int] = js.undefined,
             height: js.UndefOr[Int] = js.undefined,
             minWidth: js.UndefOr[Int] = js.undefined,
             minHeight: js.UndefOr[Int] = js.undefined,
             maxWidth: js.UndefOr[Int] = js.undefined,
             maxHeight: js.UndefOr[Int] = js.undefined
             ): BoundsSpecification = {

    js.Dynamic.literal(
      left = left,
      top = top,
      width = width,
      height = height,
      minWidth = minWidth,
      minHeight = minHeight,
      maxWidth = maxWidth,
      maxHeight = maxHeight
    ).asInstanceOf[BoundsSpecification]

  }

}

class BoundsSpecification extends js.Object {

  var left: js.UndefOr[Int] = js.native
  var top: js.UndefOr[Int] = js.native
  var width: js.UndefOr[Int] = js.native
  var height: js.UndefOr[Int] = js.native

  var minWidth: js.UndefOr[Int] = js.native
  var minHeight: js.UndefOr[Int] = js.native
  var maxWidth: js.UndefOr[Int] = js.native
  var maxHeight: js.UndefOr[Int] = js.native

}
