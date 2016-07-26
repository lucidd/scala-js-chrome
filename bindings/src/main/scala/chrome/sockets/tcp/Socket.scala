package chrome.sockets.tcp

import chrome.events.EventSource
import chrome.sockets.tcp.bindings._

import scala.concurrent.Future
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.scalajs.js.typedarray.ArrayBuffer

class Socket(val socketId: SocketId) {

  val onReceive = TCP.onReceive
    .filter(_.socketId == socketId)
    .map((event) => Socket.Received(event.data))
  val onReceiveError = TCP.onReceiveError
    .filter(_.socketId == socketId)
    .map((event) => Socket.Error(event.resultCode))
  val all: EventSource[Socket.ReceiveEvent] = onReceive.merge(onReceiveError)

  def update(properties: SocketProperties): Future[Unit] = {
    TCP.update(socketId, properties)
  }

  def setPaused(paused: Boolean): Future[Unit] = {
    TCP.setPaused(socketId, paused)
  }

  def setKeepAlive(enable: Boolean,
                   delay: js.UndefOr[Int] = js.undefined): Future[Int] = {
    TCP.setKeepAlive(socketId, enable, delay)
  }

  def setNoDelay(noDelay: Boolean): Future[Int] = {
    TCP.setNoDelay(socketId, noDelay)
  }

  def connect(peerAddress: String, peerPort: Int): Future[Int] = {
    TCP.connect(socketId, peerAddress, peerPort)
  }

  def disconnect: Future[Unit] = {
    TCP.disconnect(socketId)
  }

  def secure(options: js.UndefOr[SecureOptions]): Future[Unit] = {
    TCP.secure(socketId, options)
  }

  def send(data: ArrayBuffer): Future[SendInfo] = {
    TCP.send(socketId, data)
  }

  def close: Future[Unit] = {
    TCP.close(socketId)
  }

  def getInfo: Future[SocketInfo] = {
    TCP.getInfo(socketId)
  }

}

object Socket {

  sealed trait ReceiveEvent
  case class Received(data: ArrayBuffer) extends ReceiveEvent
  case class Error(code: Int) extends ReceiveEvent

  def apply(id: SocketId): Socket = new Socket(id)

  def apply(name: String = "",
            persistent: Boolean,
            bufferSize: Int): Future[Socket] = {
    TCP
      .create(SocketProperties(persistent, name, bufferSize))
      .map(i => Socket(i.socketId))
  }

}
