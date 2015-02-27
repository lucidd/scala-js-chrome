package chrome.sockets.tcpServer

import chrome.events.bindings.Event

import scala.concurrent.{Promise, Future}
import scala.scalajs.js
import bindings._

object TCPServer {

  def create(properties: js.UndefOr[SocketProperties] = js.undefined): Future[CreateInfo] = {
    val promise = Promise[CreateInfo]
    bindings.TCPServer.create(properties, (info: CreateInfo) => {
      promise.complete(chrome.lastErrorOrValue(info))
    })
    promise.future
  }

  def update(socketId: SocketId, properties: SocketProperties): Future[Unit] = {
    val promise = Promise[Unit]
    bindings.TCPServer.update(socketId, properties, js.Any.fromFunction0(() => {
      promise.complete(chrome.lastErrorOrValue(()))
    }))
    promise.future
  }

  def setPaused(socketId: SocketId, paused: Boolean): Future[Unit] = {
    val promise = Promise[Unit]
    bindings.TCPServer.setPaused(socketId, paused, js.Any.fromFunction0(() => {
      promise.complete(chrome.lastErrorOrValue(()))
    }))
    promise.future
  }

  def listen(socketId: SocketId, address: String, port: Int, backlog: js.UndefOr[Int] = js.undefined): Future[Int] = {
    val promise = Promise[Int]
    bindings.TCPServer.listen(socketId, address, port, backlog, (result: Int) => {
      promise.complete(chrome.lastErrorOrValue(result))
    })
    promise.future
  }

  def disconnect(socketId: SocketId): Future[Unit] = {
    val promise = Promise[Unit]
    bindings.TCPServer.disconnect(socketId, js.Any.fromFunction0(() => {
      promise.complete(chrome.lastErrorOrValue(()))
    }))
    promise.future
  }

  def close(socketId: SocketId): Future[Unit] = {
    val promise = Promise[Unit]
    bindings.TCPServer.close(socketId, js.Any.fromFunction0(() => {
      promise.complete(chrome.lastErrorOrValue(()))
    }))
    promise.future
  }

  def getInfo(socketId: SocketId): Future[SocketInfo] = {
    val promise = Promise[SocketInfo]
    bindings.TCPServer.getInfo(socketId, (info: SocketInfo) => {
      promise.complete(chrome.lastErrorOrValue(info))
    })
    promise.future
  }

  def getSockets: Future[js.Array[SocketInfo]] = {
    val promise = Promise[js.Array[SocketInfo]]
    bindings.TCPServer.getSockets((info: js.Array[SocketInfo]) => {
      promise.complete(chrome.lastErrorOrValue(info))
    })
    promise.future
  }

  val onAccept: Event[js.Function1[AcceptEvent, _]] = bindings.TCPServer.onAccept
  val onAcceptError: Event[js.Function1[AcceptErrorEvent, _]] = bindings.TCPServer.onAcceptError

}
