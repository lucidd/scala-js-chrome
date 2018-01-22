package chrome.webRequest.bindings

import scala.scalajs.js

@js.native
trait WebAuthChallenger extends js.Object {
  val host: String = js.native
  val port: Int = js.native
}
