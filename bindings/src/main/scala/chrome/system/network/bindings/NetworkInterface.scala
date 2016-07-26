package chrome.system.network.bindings

import scala.scalajs.js

@js.native
trait NetworkInterface extends js.Object {

  val name: String = js.native
  val address: String = js.native
  val prefixLength: Int = js.native

}
