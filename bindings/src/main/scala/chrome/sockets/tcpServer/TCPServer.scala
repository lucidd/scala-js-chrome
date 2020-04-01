package chrome.sockets.tcpServer

import chrome.events.EventSource
import chrome.events.EventSourceImplicits._
import chrome.sockets.tcpServer.bindings._
import chrome.utils.ErrorHandling._

import scala.concurrent.{Future, Promise}
import scala.scalajs.js
import scala.scalajs.js.JSConverters._

object TCPServer {

  val onAccept: EventSource[AcceptEvent] = bindings.TCPServer.onAccept
  val onAcceptError: EventSource[AcceptErrorEvent] =
    bindings.TCPServer.onAcceptError

  def create(properties: js.UndefOr[SocketProperties] = js.undefined)
    : Future[CreateInfo] = {
    val promise = Promise[CreateInfo]()
    bindings.TCPServer.create(properties, (info: CreateInfo) => {
      promise.complete(lastErrorOrValue(info))
    })
    promise.future
  }

  def update(socketId: SocketId, properties: SocketProperties): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.TCPServer.update(socketId, properties,
      Option[js.Function0[_]](() => promise.complete(lastErrorOrValue(()))).orUndefined)
    promise.future
  }

  def setPaused(socketId: SocketId, paused: Boolean): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.TCPServer.setPaused(socketId, paused,
      Option[js.Function0[_]](() => promise.complete(lastErrorOrValue(()))).orUndefined)
    promise.future
  }

  def listen(socketId: SocketId,
             address: String,
             port: Int,
             backlog: js.UndefOr[Int] = js.undefined): Future[Int] = {
    val promise = Promise[Int]()
    bindings.TCPServer
      .listen(socketId, address, port, backlog, (result: Int) => {
        promise.complete(lastErrorOrValue(result))
      })
    promise.future
  }

  def disconnect(socketId: SocketId): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.TCPServer.disconnect(socketId,
      Option[js.Function0[_]](() => promise.complete(lastErrorOrValue(()))).orUndefined)
    promise.future
  }

  def close(socketId: SocketId): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.TCPServer.close(socketId,
      Option[js.Function0[_]](() => promise.complete(lastErrorOrValue(()))).orUndefined)
    promise.future
  }

  def getInfo(socketId: SocketId): Future[SocketInfo] = {
    val promise = Promise[SocketInfo]()
    bindings.TCPServer.getInfo(socketId, (info: SocketInfo) => {
      promise.complete(lastErrorOrValue(info))
    })
    promise.future
  }

  def getSockets: Future[js.Array[SocketInfo]] = {
    val promise = Promise[js.Array[SocketInfo]]()
    bindings.TCPServer.getSockets((info: js.Array[SocketInfo]) => {
      promise.complete(lastErrorOrValue(info))
    })
    promise.future
  }

}
