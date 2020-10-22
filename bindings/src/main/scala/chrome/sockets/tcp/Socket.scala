package chrome.sockets.tcp

import chrome.events.EventSource
import chrome.sockets.tcp
import chrome.sockets.tcp.bindings.{SecureOptions, SendInfo, SocketId, SocketInfo, SocketProperties}
import chrome.utils.ErrorHandling.lastErrorOrValue

import scala.concurrent.{Future, Promise}
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.scalajs.js.JSConverters._
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
    val promise = Promise[Unit]()
    tcp.bindings.TCP.update(
      socketId,
      properties,
      Option[js.Function0[_]](() => promise.complete(lastErrorOrValue(()))).orUndefined
    )
    promise.future
  }

  def setPaused(paused: Boolean): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.TCP.setPaused(
      socketId,
      paused,
      Option[js.Function0[_]](() => promise.complete(lastErrorOrValue(()))).orUndefined
    )
    promise.future
  }

  def setKeepAlive(enable: Boolean, delay: js.UndefOr[Int] = js.undefined): Future[Int] = {
    val promise = Promise[Int]()
    bindings.TCP.setKeepAlive(socketId, enable, delay, (i: Int) => promise.complete(lastErrorOrValue(i)))
    promise.future
  }

  def setNoDelay(noDelay: Boolean): Future[Int] = {
    val promise = Promise[Int]()
    bindings.TCP.setNoDelay(socketId, noDelay, (i: Int) => promise.complete(lastErrorOrValue(i)))
    promise.future
  }

  def connect(peerAddress: String, peerPort: Int): Future[Int] = {
    val promise = Promise[Int]()
    bindings.TCP.connect(socketId, peerAddress, peerPort, (i: Int) => promise.complete(lastErrorOrValue(i)))
    promise.future
  }

  def disconnect: Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.TCP.disconnect(socketId, Option[js.Function0[_]](() => promise.complete(lastErrorOrValue(()))).orUndefined)
    promise.future
  }

  def secure(options: js.UndefOr[SecureOptions]): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.TCP.secure(socketId, options, () => promise.complete(lastErrorOrValue(())))
    promise.future
  }

  def send(data: ArrayBuffer): Future[SendInfo] = {
    val promise = Promise[SendInfo]()
    bindings.TCP.send(socketId, data, (info: SendInfo) => promise.complete(lastErrorOrValue(info)))
    promise.future
  }

  def close: Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.TCP.close(socketId, () => promise.complete(lastErrorOrValue(())))
    promise.future
  }

  def getInfo: Future[SocketInfo] = {
    val promise = Promise[SocketInfo]()
    bindings.TCP.getInfo(socketId, (info: SocketInfo) => promise.complete(lastErrorOrValue(info)))
    promise.future
  }

}

object Socket {

  sealed trait ReceiveEvent
  case class Received(data: ArrayBuffer) extends ReceiveEvent
  case class Error(code: Int) extends ReceiveEvent

  def apply(id: SocketId): Socket = new Socket(id)

  def apply(name: String = "", persistent: Boolean, bufferSize: Int): Future[Socket] = {

    tcp.TCP
      .create(SocketProperties(persistent, name, bufferSize))
      .map(i => Socket(i.socketId))
  }

}
