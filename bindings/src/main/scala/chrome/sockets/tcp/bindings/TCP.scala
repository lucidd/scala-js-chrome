package chrome.sockets.tcp.bindings

import chrome.events.bindings.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.typedarray.ArrayBuffer
import scala.scalajs.js.{UndefOr, undefined}

@js.native
@JSGlobal("chrome.sockets.tcp")
object TCP extends js.Object {

  val onReceive: Event[js.Function1[ReceiveEvent, _]] = js.native
  val onReceiveError: Event[js.Function1[ReceiveErrorEvent, _]] = js.native

  def create(properties: UndefOr[SocketProperties] = undefined, callback: js.Function1[CreateInfo, _]): Unit = js.native

  def update(socketId: SocketId, properties: SocketProperties, callback: UndefOr[js.Function0[_]] = undefined): Unit =
    js.native

  def setPaused(socketId: SocketId, paused: Boolean, callback: UndefOr[js.Function0[_]] = undefined): Unit = js.native

  def setKeepAlive(
      socketId: SocketId,
      enable: Boolean,
      delay: UndefOr[Int] = undefined,
      callback: js.Function1[Int, _]
  ): Unit = js.native

  def setNoDelay(socketId: SocketId, noDelay: Boolean, callback: js.Function1[Int, _]): Unit = js.native

  def connect(socketId: SocketId, peerAddress: String, peerPort: Int, callback: js.Function1[Int, _]): Unit = js.native

  def disconnect(socketId: SocketId, callback: UndefOr[js.Function0[_]] = undefined): Unit = js.native

  def secure(socketId: SocketId, options: UndefOr[SecureOptions] = undefined, callback: js.Function0[_]): Unit =
    js.native

  def send(socketId: SocketId, data: ArrayBuffer, callback: js.Function1[SendInfo, _]): Unit = js.native

  def close(socketId: SocketId, callback: js.Function0[_]): Unit = js.native

  def getInfo(socketId: SocketId, callback: js.Function1[SocketInfo, _]): Unit = js.native

  def getSockets(callback: js.Function1[js.Array[SocketInfo], _]): Unit =
    js.native

}
