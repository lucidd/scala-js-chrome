package chrome.sockets.tcpServer

import chrome.events.EventSource
import chrome.sockets.tcp
import chrome.sockets.tcpServer.bindings._

import scala.concurrent.Future
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

class Socket(val socketId: SocketId) {

  val onAccept = TCPServer.onAccept
    .filter(_.socketId == socketId)
    .map(event => Socket.Accepted(tcp.Socket(event.clientSocketId)))
  val onAcceptError = TCPServer.onAcceptError
    .filter(_.socketId == socketId)
    .map(event => Socket.Error(event.resultCode))
  val all: EventSource[Socket.AcceptEvent] = onAccept.merge(onAcceptError)

  def update(properties: SocketProperties): Future[Unit] = {
    TCPServer.update(socketId, properties)
  }

  def setPaused(paused: Boolean): Future[Unit] = {
    TCPServer.setPaused(socketId, paused)
  }

  def listen(address: String, port: Int, backlog: js.UndefOr[Int] = js.undefined): Future[Int] = {
    TCPServer.listen(socketId, address, port, backlog)
  }

  def disconnect: Future[Unit] = {
    TCPServer.disconnect(socketId)
  }

  def close: Future[Unit] = {
    TCPServer.close(socketId)
  }

  def getInfo: Future[SocketInfo] = {
    TCPServer.getInfo(socketId)
  }

}

object Socket {

  sealed trait AcceptEvent
  case class Accepted(client: chrome.sockets.tcp.Socket) extends AcceptEvent
  case class Error(code: Int) extends AcceptEvent

  def apply(id: SocketId): Socket = new Socket(id)

  def apply(name: String = "", persistent: Boolean): Future[Socket] = {
    TCPServer.create(SocketProperties(persistent, name)).map(i => Socket(i.socketId))
  }

}
