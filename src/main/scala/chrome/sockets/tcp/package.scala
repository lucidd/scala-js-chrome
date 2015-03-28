package chrome.sockets

import chrome.sockets.tcp.bindings.{SecureOptions, SendInfo, SocketId, SocketInfo, SocketProperties}

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.typedarray.ArrayBuffer

package object tcp {

  implicit class Socket(val socketId: SocketId) extends AnyVal {

    def update(properties: SocketProperties): Future[Unit] = {
      TCP.update(socketId, properties)
    }

    def setPaused(paused: Boolean): Future[Unit] = {
      TCP.setPaused(socketId, paused)
    }

    def setKeepAlive(enable: Boolean, delay: js.UndefOr[Int] = js.undefined): Future[Int] = {
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

}
