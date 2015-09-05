package chrome.app.runtime.bindings

import scala.scalajs.js

@js.native
trait Request extends js.Object {

  def embedderId: String = js.native

  def data: js.UndefOr[js.Any] = js.native

  def allow(url: String): Unit = js.native

  def deny(): Unit = js.native

}
