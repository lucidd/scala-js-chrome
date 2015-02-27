package chrome.sockets.tcpServer.bindings

import chrome.events.bindings.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@JSName("chrome.sockets.tcpServer")
object TCPServer extends js.Object {

  def create(properties: js.UndefOr[SocketProperties] = js.undefined, callback: js.Function1[CreateInfo, _]): Unit = js.native
  def update(socketId: SocketId, properties: SocketProperties, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native
  def setPaused(socketId: SocketId, paused: Boolean, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native
  def listen(socketId: SocketId, address: String, port: Int, backlog: js.UndefOr[Int] = js.undefined, callback: js.Function1[Int, _]): Unit = js.native
  def disconnect(socketId: SocketId, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native
  def close(socketId: SocketId, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native
  def getInfo(socketId: SocketId, callback: js.Function1[SocketInfo ,_]): Unit = js.native
  def getSockets(callback: js.Function1[js.Array[SocketInfo], _]): Unit = js.native


  val onAccept: Event[js.Function1[AcceptEvent, _]] = js.native
  val onAcceptError: Event[js.Function1[AcceptErrorEvent, _]] = js.native

}
