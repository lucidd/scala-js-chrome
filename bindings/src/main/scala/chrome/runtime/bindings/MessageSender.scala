package chrome.runtime.bindings

import scala.scalajs.js

@js.native
trait MessageSender extends js.Object {

  def id: js.UndefOr[String] = js.native

  def url: js.UndefOr[String] = js.native

  def tlsChannelId: js.UndefOr[String] = js.native

}
