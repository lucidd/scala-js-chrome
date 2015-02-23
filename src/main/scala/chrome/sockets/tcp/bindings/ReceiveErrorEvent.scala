package chrome.sockets.tcp.bindings

import scala.scalajs.js

class ReceiveErrorEvent extends js.Object {

  def socketId: SocketId = js.native
  def resultCode: Int = js.native

}
