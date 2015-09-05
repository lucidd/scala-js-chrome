package chrome.sockets.tcpServer.bindings

import scala.scalajs.js

@js.native
trait SocketInfo extends js.Object {

  def socketId: SocketId = js.native

  def persistent: Boolean = js.native

  def name: js.UndefOr[String] = js.native

  def paused: Boolean = js.native

  def localAddress: js.UndefOr[String] = js.native

  def localPort: js.UndefOr[Int] = js.native

}
