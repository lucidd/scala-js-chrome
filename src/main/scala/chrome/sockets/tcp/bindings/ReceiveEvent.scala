package chrome.sockets.tcp.bindings

import scala.scalajs.js
import scala.scalajs.js.typedarray.ArrayBuffer

class ReceiveEvent extends js.Object {

  def socketId: SocketId = js.native
  def data: ArrayBuffer = js.native

}
