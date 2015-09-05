package chrome.app.window.bindings

import scala.scalajs.js

@js.native
trait ContentBounds extends js.Object {

  var left: js.UndefOr[Int] = js.native
  var top: js.UndefOr[Int] = js.native
  var width: js.UndefOr[Int] = js.native
  var height: js.UndefOr[Int] = js.native

}
