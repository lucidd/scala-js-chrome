package chrome.app.window.bindings

import scala.scalajs.js

class Bounds extends js.Object {

  var left: Int = js.native
  var top: Int = js.native
  var width: Int = js.native
  var height: Int = js.native

  var minWidth: js.UndefOr[Int] = js.native
  var minHeight: js.UndefOr[Int] = js.native
  var maxWidth: js.UndefOr[Int] = js.native
  var maxHeight: js.UndefOr[Int] = js.native

  def setPosition(top: Int, left: Int): Unit = js.native

  def setSize(width: Int, height: Int): Unit = js.native

  def setMinimumSize(minWidth: Int, minHeight: Int): Unit = js.native

  def setMaximumSize(maxWidth: Int, maxHeight: Int): Unit = js.native

}
