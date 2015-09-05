package chrome.sockets.tcp.bindings

import scala.scalajs.js

@js.native
trait SendInfo extends js.Object {

  def resultCode: Int = js.native

  def bytesSent: js.UndefOr[Int] = js.native

}
