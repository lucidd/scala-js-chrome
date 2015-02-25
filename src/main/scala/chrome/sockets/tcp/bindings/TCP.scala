package chrome.sockets.tcp.bindings

import chrome.events.bindings.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.typedarray.ArrayBuffer


@JSName("chrome.sockets.tcp")
object TCP extends js.Object {

  def create(properties: js.UndefOr[SocketProperties] = js.undefined, callback: js.Function1[CreateInfo, _]): Unit = js.native
  def update(socketId: SocketId, properties: SocketProperties, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native
  def setPaused(socketId: SocketId, paused: Boolean, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native
  def setKeepAlive(socketId: SocketId, enable: Boolean, delay: js.UndefOr[Int] = js.undefined, callback: js.Function1[Int, _]): Unit = js.native
  def setNoDelay(socketId: SocketId, noDelay: Boolean, callback: js.Function1[Int, _]): Unit = js.native
  def connect(socketId: SocketId, peerAddress: String, peerPort: Int, callback: js.Function1[Int, _]): Unit = js.native
  def disconnect(socketId: SocketId, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native
  def secure(socketId: SocketId, options: js.UndefOr[SecureOptions] = js.undefined, callback: js.Function0[_]): Unit = js.native
  def send(socketId: SocketId, data: ArrayBuffer, callback: js.Function1[SendInfo, _]): Unit = js.native
  def close(socketId: SocketId, callback: js.Function0[_]): Unit = js.native
  def getInfo(socketId: SocketId, callback: js.Function1[SocketInfo, _]): Unit = js.native
  def getSockets(callback: js.Function1[js.Array[SocketInfo], _]): Unit = js.native


  val onReceive: Event[js.Function1[ReceiveEvent, _]] = js.native
  val onReceiveError: Event[js.Function1[ReceiveErrorEvent, _]] = js.native

}
