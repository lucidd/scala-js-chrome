package chrome.sockets.tcpServer.bindings

import chrome.events.bindings.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.{UndefOr, undefined}

@js.native
@JSGlobal("chrome.sockets.tcpServer")
object TCPServer extends js.Object {

  val onAccept: Event[js.Function1[AcceptEvent, _]] = js.native
  val onAcceptError: Event[js.Function1[AcceptErrorEvent, _]] = js.native

  def create(properties: UndefOr[SocketProperties] = undefined, callback: js.Function1[CreateInfo, _]): Unit = js.native

  def update(socketId: SocketId, properties: SocketProperties, callback: UndefOr[js.Function0[_]] = undefined): Unit =
    js.native

  def setPaused(socketId: SocketId, paused: Boolean, callback: UndefOr[js.Function0[_]] = undefined): Unit = js.native

  def listen(
      socketId: SocketId,
      address: String,
      port: Int,
      backlog: UndefOr[Int] = undefined,
      callback: js.Function1[Int, _]
  ): Unit = js.native

  def disconnect(socketId: SocketId, callback: UndefOr[js.Function0[_]] = undefined): Unit = js.native

  def close(socketId: SocketId, callback: UndefOr[js.Function0[_]] = undefined): Unit = js.native

  def getInfo(socketId: SocketId, callback: js.Function1[SocketInfo, _]): Unit = js.native

  def getSockets(callback: js.Function1[js.Array[SocketInfo], _]): Unit =
    js.native

}
