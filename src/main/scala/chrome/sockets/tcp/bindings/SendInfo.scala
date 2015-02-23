package chrome.sockets.tcp.bindings

import scala.scalajs.js

class SendInfo extends js.Object {

  def resultCode: Int = js.native
  def bytesSent: js.UndefOr[Int] = js.native

}
