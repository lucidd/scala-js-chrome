package chrome.sockets.tcp

import bindings._
import chrome.events.bindings.Event
import scala.concurrent.{Promise, Future}
import scala.scalajs.js
import scala.scalajs.js.typedarray.ArrayBuffer

object TCP {

  def create(properties: js.UndefOr[SocketProperties] = js.undefined): Future[CreateInfo] = {
    val promise = Promise[CreateInfo]
    bindings.TCP.create(properties, (info: CreateInfo) => {
      promise.complete(chrome.lastErrorOrValue(info))
    })
    promise.future
  }

  def update(socketId: SocketId, properties: SocketProperties): Future[Unit] = {
    val promise = Promise[Unit]
    bindings.TCP.update(socketId, properties, js.Any.fromFunction0(() => {
      promise.complete(chrome.lastErrorOrValue(()))
    }))
    promise.future
  }

  def setPaused(socketId: SocketId, paused: Boolean): Future[Unit] = {
    val promise = Promise[Unit]
    bindings.TCP.setPaused(socketId, paused, js.Any.fromFunction0(() => {
      promise.complete(chrome.lastErrorOrValue(()))
    }))
    promise.future
  }

  def setKeepAlive(socketId: SocketId, enable: Boolean, delay: js.UndefOr[Int] = js.undefined): Future[Int] = {
    val promise = Promise[Int]
    bindings.TCP.setKeepAlive(socketId, enable, delay, (result: Int) => {
      promise.complete(chrome.lastErrorOrValue(result))
    })
    promise.future
  }

  def setNoDelay(socketId: SocketId, noDelay: Boolean): Future[Int] = {
    val promise = Promise[Int]
    bindings.TCP.setNoDelay(socketId, noDelay, (result: Int) => {
      promise.complete(chrome.lastErrorOrValue(result))
    })
    promise.future
  }

  def connect(socketId: SocketId, peerAddress: String, peerPort: Int): Future[Int] = {
    val promise = Promise[Int]
    bindings.TCP.connect(socketId, peerAddress, peerPort, (result: Int) => {
      promise.complete(chrome.lastErrorOrValue(result))
    })
    promise.future
  }

  def disconnect(socketId: SocketId): Future[Unit] = {
    val promise = Promise[Unit]
    bindings.TCP.disconnect(socketId, js.Any.fromFunction0(() => {
      promise.complete(chrome.lastErrorOrValue(()))
    }))
    promise.future
  }

  def secure(socketId: SocketId, options: js.UndefOr[SecureOptions]): Future[Unit] = {
    val promise = Promise[Unit]
    bindings.TCP.secure(socketId, options, () => {
      promise.complete(chrome.lastErrorOrValue(()))
    })
    promise.future
  }

  def send(socketId: SocketId, data: ArrayBuffer): Future[SendInfo] = {
    val promise = Promise[SendInfo]
    bindings.TCP.send(socketId, data, (sendInfo: SendInfo) => {
      promise.complete(chrome.lastErrorOrValue(sendInfo))
    })
    promise.future
  }

  def close(socketId: SocketId): Future[Unit] = {
    val promise = Promise[Unit]
    bindings.TCP.close(socketId, () => {
      promise.complete(chrome.lastErrorOrValue(()))
    })
    promise.future
  }

  def getInfo(socketId: SocketId): Future[SocketInfo] = {
    val promise = Promise[SocketInfo]
    bindings.TCP.getInfo(socketId, (info: SocketInfo) => {
      promise.complete(chrome.lastErrorOrValue(info))
    })
    promise.future
  }

  def getSockets: Future[js.Array[SocketInfo]] = {
    val promise = Promise[js.Array[SocketInfo]]
    bindings.TCP.getSockets((sockets: js.Array[SocketInfo]) => {
      promise.complete(chrome.lastErrorOrValue(sockets))
    })
    promise.future
  }


  val onReceive: Event[js.Function1[ReceiveEvent, _]] = bindings.TCP.onReceive
  val onReceiveError: Event[js.Function1[ReceiveErrorEvent, _]] = bindings.TCP.onReceiveError

}
