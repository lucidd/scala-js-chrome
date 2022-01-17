package chrome.sockets.tcpServer.bindings

import scala.scalajs.js
import scala.scalajs.js.|.undefOr2jsAny

@js.native
trait SocketProperties extends js.Object {

  def persistent: js.UndefOr[Boolean] = js.native

  def name: js.UndefOr[String] = js.native

}

object SocketProperties {

  def apply(
      persistent: js.UndefOr[Boolean] = js.undefined,
      name: js.UndefOr[String] = js.undefined
  ): SocketProperties = {
    js.Dynamic
      .literal(
        persistent = persistent,
        name = name
      )
      .asInstanceOf[SocketProperties]
  }

}
