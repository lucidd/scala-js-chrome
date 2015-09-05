package chrome.runtime.bindings

import scala.scalajs.js

@js.native
trait SendMessageOptions extends js.Object {

  val includeTlsChannelId: js.UndefOr[Boolean] = js.native

}
