package chrome.runtime.bindings

import scala.scalajs.js


@js.native
trait Error extends js.Object {

  def message: js.UndefOr[String] = js.native

}
