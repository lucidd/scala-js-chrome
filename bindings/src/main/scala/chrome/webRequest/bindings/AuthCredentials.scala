package chrome.webRequest.bindings

import scala.scalajs.js

@js.native
trait AuthCredentials extends js.Object {
  val username: String = js.native
  val password: String = js.native
}
