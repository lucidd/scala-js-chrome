package chrome.sockets.tcpServer.bindings

import scala.scalajs.js

@js.native
trait AcceptErrorEvent extends js.Object {

  def socketId: SocketId = js.native

  def resultCode: Int = js.native

}
