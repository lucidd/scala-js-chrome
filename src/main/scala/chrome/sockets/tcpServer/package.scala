package chrome.sockets

import chrome.sockets.tcpServer.bindings.{SocketId, SocketInfo, SocketProperties}

import scala.concurrent.Future
import scala.scalajs.js


package object tcpServer {

  implicit class Socket(val socketId: SocketId) extends AnyVal {

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

}
