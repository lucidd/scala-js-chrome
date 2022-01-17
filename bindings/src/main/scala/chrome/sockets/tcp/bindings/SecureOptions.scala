package chrome.sockets.tcp.bindings

import scala.scalajs.js
import scala.scalajs.js.|.undefOr2jsAny

@js.native
trait SecureOptions extends js.Object {

  def tlsVersion: js.UndefOr[TLSVersionBounds] = js.native

}

object SecureOptions {

  def apply(tlsVersion: js.UndefOr[TLSVersionBounds] = js.undefined): SecureOptions = {
    js.Dynamic
      .literal(
        tlsVersion = tlsVersion
      )
      .asInstanceOf[SecureOptions]
  }

}
