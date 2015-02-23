package chrome.sockets.tcp.bindings

import scala.scalajs.js

class SocketProperties extends js.Object {

  def persistent: js.UndefOr[Boolean] = js.native
  def name: js.UndefOr[String] = js.native
  def bufferSize: js.UndefOr[Int] = js.native

}
