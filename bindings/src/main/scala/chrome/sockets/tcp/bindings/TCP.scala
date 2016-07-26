package chrome.sockets.tcp.bindings

import chrome.events.bindings.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.typedarray.ArrayBuffer
import scala.scalajs.js.{UndefOr, native, undefined}

@js.native
@JSName("chrome.sockets.tcp")
object TCP extends js.Object {

  val onReceive: Event[js.Function1[ReceiveEvent, _]] = native
  val onReceiveError: Event[js.Function1[ReceiveErrorEvent, _]] = native

  def create(properties: UndefOr[SocketProperties] = undefined,
             callback: js.Function1[CreateInfo, _]): Unit = native

  def update(socketId: SocketId,
             properties: SocketProperties,
             callback: UndefOr[js.Function0[_]] = undefined): Unit = native

  def setPaused(socketId: SocketId,
                paused: Boolean,
                callback: UndefOr[js.Function0[_]] = undefined): Unit = native

  def setKeepAlive(socketId: SocketId,
                   enable: Boolean,
                   delay: UndefOr[Int] = undefined,
                   callback: js.Function1[Int, _]): Unit = native

  def setNoDelay(socketId: SocketId,
                 noDelay: Boolean,
                 callback: js.Function1[Int, _]): Unit = native

  def connect(socketId: SocketId,
              peerAddress: String,
              peerPort: Int,
              callback: js.Function1[Int, _]): Unit = native

  def disconnect(socketId: SocketId,
                 callback: UndefOr[js.Function0[_]] = undefined): Unit = native

  def secure(socketId: SocketId,
             options: UndefOr[SecureOptions] = undefined,
             callback: js.Function0[_]): Unit = native

  def send(socketId: SocketId,
           data: ArrayBuffer,
           callback: js.Function1[SendInfo, _]): Unit = native

  def close(socketId: SocketId, callback: js.Function0[_]): Unit = native

  def getInfo(socketId: SocketId,
              callback: js.Function1[SocketInfo, _]): Unit = native

  def getSockets(callback: js.Function1[js.Array[SocketInfo], _]): Unit =
    native

}
