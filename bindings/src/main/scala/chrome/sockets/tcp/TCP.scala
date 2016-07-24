package chrome.sockets.tcp

import chrome.events.EventSource
import chrome.events.EventSourceImplicits._
import chrome.sockets.tcp.bindings._
import chrome.utils.ErrorHandling._

import scala.concurrent.{Future, Promise}
import scala.scalajs.js
import scala.scalajs.js.typedarray.ArrayBuffer

object TCP {

  val onReceive: EventSource[ReceiveEvent] = bindings.TCP.onReceive
  val onReceiveError: EventSource[ReceiveErrorEvent] = bindings.TCP.onReceiveError

  def create(properties: js.UndefOr[SocketProperties] = js.undefined): Future[CreateInfo] = {
    val promise = Promise[CreateInfo]()
    bindings.TCP.create(properties, (info: CreateInfo) => {
      promise.complete(lastErrorOrValue(info))
    })
    promise.future
  }

  def update(socketId: SocketId, properties: SocketProperties): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.TCP.update(socketId, properties, js.Any.fromFunction0(() => {
      promise.complete(lastErrorOrValue(()))
    }))
    promise.future
  }

  def setPaused(socketId: SocketId, paused: Boolean): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.TCP.setPaused(socketId, paused, js.Any.fromFunction0(() => {
      promise.complete(lastErrorOrValue(()))
    }))
    promise.future
  }

  def setKeepAlive(socketId: SocketId, enable: Boolean, delay: js.UndefOr[Int] = js.undefined): Future[Int] = {
    val promise = Promise[Int]()
    bindings.TCP.setKeepAlive(socketId, enable, delay, (result: Int) => {
      promise.complete(lastErrorOrValue(result))
    })
    promise.future
  }

  def setNoDelay(socketId: SocketId, noDelay: Boolean): Future[Int] = {
    val promise = Promise[Int]()
    bindings.TCP.setNoDelay(socketId, noDelay, (result: Int) => {
      promise.complete(lastErrorOrValue(result))
    })
    promise.future
  }

  def connect(socketId: SocketId, peerAddress: String, peerPort: Int): Future[Int] = {
    val promise = Promise[Int]()
    bindings.TCP.connect(socketId, peerAddress, peerPort, (result: Int) => {
      promise.complete(lastErrorOrValue(result))
    })
    promise.future
  }

  def disconnect(socketId: SocketId): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.TCP.disconnect(socketId, js.Any.fromFunction0(() => {
      promise.complete(lastErrorOrValue(()))
    }))
    promise.future
  }

  def secure(socketId: SocketId, options: js.UndefOr[SecureOptions]): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.TCP.secure(socketId, options, () => {
      promise.complete(lastErrorOrValue(()))
    })
    promise.future
  }

  def send(socketId: SocketId, data: ArrayBuffer): Future[SendInfo] = {
    val promise = Promise[SendInfo]()
    bindings.TCP.send(socketId, data, (sendInfo: SendInfo) => {
      promise.complete(lastErrorOrValue(sendInfo))
    })
    promise.future
  }

  def close(socketId: SocketId): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.TCP.close(socketId, () => {
      promise.complete(lastErrorOrValue(()))
    })
    promise.future
  }

  def getInfo(socketId: SocketId): Future[SocketInfo] = {
    val promise = Promise[SocketInfo]()
    bindings.TCP.getInfo(socketId, (info: SocketInfo) => {
      promise.complete(lastErrorOrValue(info))
    })
    promise.future
  }

  def getSockets: Future[js.Array[SocketInfo]] = {
    val promise = Promise[js.Array[SocketInfo]]()
    bindings.TCP.getSockets((sockets: js.Array[SocketInfo]) => {
      promise.complete(lastErrorOrValue(sockets))
    })
    promise.future
  }

}
