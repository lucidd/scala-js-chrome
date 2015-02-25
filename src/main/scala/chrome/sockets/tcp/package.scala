package chrome.sockets

import chrome.sockets.tcp.bindings._

import scala.concurrent.{Future, Promise}
import scala.scalajs.js
import scala.scalajs.js.typedarray.ArrayBuffer

package object tcp {


  implicit class Socket(val socketId: SocketId) extends AnyVal {

    def update(properties: SocketProperties): Future[Unit] = {
      val promise = Promise[Unit]
      bindings.TCP.update(socketId, properties, js.Any.fromFunction0(() => {
        promise.complete(chrome.lastErrorOrValue(()))
      }))
      promise.future
    }

    def setPaused(paused: Boolean): Future[Unit] = {
      val promise = Promise[Unit]
      bindings.TCP.setPaused(socketId, paused, js.Any.fromFunction0(() => {
        promise.complete(chrome.lastErrorOrValue(()))
      }))
      promise.future
    }

    def setKeepAlive(enable: Boolean, delay: js.UndefOr[Int] = js.undefined): Future[Int] = {
      val promise = Promise[Int]
      bindings.TCP.setKeepAlive(socketId, enable, delay, (result: Int) => {
        promise.complete(chrome.lastErrorOrValue(result))
      })
      promise.future
    }

    def setNoDelay(noDelay: Boolean): Future[Int] = {
      val promise = Promise[Int]
      bindings.TCP.setNoDelay(socketId, noDelay, (result: Int) => {
        promise.complete(chrome.lastErrorOrValue(result))
      })
      promise.future
    }

    def connect(peerAddress: String, peerPort: Int): Future[Int] = {
      val promise = Promise[Int]
      bindings.TCP.connect(socketId, peerAddress, peerPort, (result: Int) => {
        promise.complete(chrome.lastErrorOrValue(result))
      })
      promise.future
    }

    def disconnect: Future[Unit] = {
      val promise = Promise[Unit]
      bindings.TCP.disconnect(socketId, js.Any.fromFunction0(() => {
        promise.complete(chrome.lastErrorOrValue(()))
      }))
      promise.future
    }

    def secure(options: js.UndefOr[SecureOptions]): Future[Unit] = {
      val promise = Promise[Unit]
      bindings.TCP.secure(socketId, options, () => {
        promise.complete(chrome.lastErrorOrValue(()))
      })
      promise.future
    }

    def send(data: ArrayBuffer): Future[SendInfo] = {
      val promise = Promise[SendInfo]
      bindings.TCP.send(socketId, data, (sendInfo: SendInfo) => {
        promise.complete(chrome.lastErrorOrValue(sendInfo))
      })
      promise.future
    }

    def close: Future[Unit] = {
      val promise = Promise[Unit]
      bindings.TCP.close(socketId, () => {
        promise.complete(chrome.lastErrorOrValue(()))
      })
      promise.future
    }

    def getInfo: Future[SocketInfo] = {
      val promise = Promise[SocketInfo]
      bindings.TCP.getInfo(socketId, (info: SocketInfo) => {
        promise.complete(chrome.lastErrorOrValue(info))
      })
      promise.future
    }

  }

}
