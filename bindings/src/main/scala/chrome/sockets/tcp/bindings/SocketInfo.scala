package chrome.sockets.tcp.bindings

import scala.scalajs.js

class SocketInfo extends js.Object {

  def socketId: SocketId = js.native

  def persistent: Boolean = js.native

  def name: js.UndefOr[String] = js.native

  def bufferSize: js.UndefOr[Int] = js.native

  def paused: Boolean = js.native

  def connected: Boolean = js.native

  def localAddress: js.UndefOr[String] = js.native

  def localPort: js.UndefOr[Int] = js.native

  def peerAddress: js.UndefOr[String] = js.native

  def peerPort: js.UndefOr[Int] = js.native

}
