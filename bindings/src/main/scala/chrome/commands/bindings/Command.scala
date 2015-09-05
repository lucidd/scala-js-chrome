package chrome.commands.bindings

import scala.scalajs.js

@js.native
trait Command extends js.Object {

  val name: js.UndefOr[String] = js.native
  val description: js.UndefOr[String] = js.native
  val shortcut: js.UndefOr[String] = js.native

}
