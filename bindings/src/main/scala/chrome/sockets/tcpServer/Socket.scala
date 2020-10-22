package chrome.sockets.tcpServer

import chrome.events.EventSource
import chrome.sockets.tcp
import chrome.sockets.tcpServer
import chrome.sockets.tcpServer.bindings.{SocketId, SocketInfo, SocketProperties}
import chrome.utils.ErrorHandling.lastErrorOrValue

import scala.concurrent.{Future, Promise}
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.scalajs.js.JSConverters._

class Socket(val socketId: SocketId) {

  val onAccept = TCPServer.onAccept
    .filter(_.socketId == socketId)
    .map(event => Socket.Accepted(tcp.Socket(event.clientSocketId)))

  val onAcceptError = TCPServer.onAcceptError
    .filter(_.socketId == socketId)
    .map(event => Socket.Error(event.resultCode))
  val all: EventSource[Socket.AcceptEvent] = onAccept.merge(onAcceptError)

  def update(properties: SocketProperties): Future[Unit] = {
    val promise = Promise[Unit]()
    tcpServer.bindings.TCPServer.update(
      socketId,
      properties,
      Option[js.Function0[_]](() => promise.complete(lastErrorOrValue(()))).orUndefined
    )
    promise.future
  }

  def setPaused(paused: Boolean): Future[Unit] = {
    val promise = Promise[Unit]()
    tcpServer.bindings.TCPServer.setPaused(
      socketId,
      paused,
      Option[js.Function0[_]](() => promise.complete(lastErrorOrValue(()))).orUndefined
    )
    promise.future
  }

  def listen(address: String, port: Int, backlog: js.UndefOr[Int] = js.undefined): Future[Int] = {
    val promise = Promise[Int]()
    tcpServer.bindings.TCPServer.listen(
      socketId,
      address,
      port,
      backlog,
      (result: Int) => {
        promise.complete(lastErrorOrValue(result))
      }
    )
    promise.future
  }

  def disconnect: Future[Unit] = {
    val promise = Promise[Unit]()
    tcpServer.bindings.TCPServer
      .disconnect(socketId, Option[js.Function0[_]](() => promise.complete(lastErrorOrValue(()))).orUndefined)
    promise.future
  }

  def close: Future[Unit] = {
    val promise = Promise[Unit]()
    tcpServer.bindings.TCPServer
      .close(socketId, Option[js.Function0[_]](() => promise.complete(lastErrorOrValue(()))).orUndefined)
    promise.future
  }

  def getInfo: Future[SocketInfo] = {
    val promise = Promise[SocketInfo]()
    tcpServer.bindings.TCPServer.getInfo(
      socketId,
      (info: SocketInfo) => {
        promise.complete(lastErrorOrValue(info))
      }
    )
    promise.future
  }

}

object Socket {

  sealed trait AcceptEvent
  case class Accepted(client: chrome.sockets.tcp.Socket) extends AcceptEvent
  case class Error(code: Int) extends AcceptEvent

  def apply(id: SocketId): Socket = new Socket(id)

  def apply(name: String = "", persistent: Boolean): Future[Socket] = {
    TCPServer
      .create(SocketProperties(persistent, name))
      .map(i => Socket(i.socketId))
  }

}
