package chrome.sockets.tcp.bindings

import scala.scalajs.js

@js.native
trait TLSVersionBounds extends js.Object {

  def min: js.UndefOr[TLSVersionBounds.Version] = js.native

  def max: js.UndefOr[TLSVersionBounds.Version] = js.native

}

object TLSVersionBounds {

  type Version = String

  val SSL3: Version = "ssl3"
  val TLS1: Version = "tls1"
  val TLS1_1: Version = "tls1.1"
  val TLS1_2: Version = "tls1.2"

  def apply(min: js.UndefOr[Version] = js.undefined,
            max: js.UndefOr[Version] = js.undefined): TLSVersionBounds = {
    js.Dynamic
      .literal(
          min = min,
          max = max
      )
      .asInstanceOf[TLSVersionBounds]
  }

}
