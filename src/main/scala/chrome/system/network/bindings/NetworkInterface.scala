package chrome.system.network.bindings

import scala.scalajs.js


class NetworkInterface extends js.Object {

  def name: String = js.native
  def address: String = js.native
  def prefixLength: Int = js.native

}