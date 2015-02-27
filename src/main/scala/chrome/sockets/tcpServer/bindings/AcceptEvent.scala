package chrome.sockets.tcpServer.bindings

import scala.scalajs.js

class AcceptEvent extends js.Object {

  def socketId: SocketId = js.native
  def clientSocketId: chrome.sockets.tcp.bindings.SocketId = js.native

}
