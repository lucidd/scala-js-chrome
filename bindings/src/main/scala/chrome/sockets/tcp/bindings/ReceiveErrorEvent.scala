package chrome.sockets.tcp.bindings

import scala.scalajs.js

@js.native
trait ReceiveErrorEvent extends js.Object {

  def socketId: SocketId = js.native

  def resultCode: Int = js.native

}
