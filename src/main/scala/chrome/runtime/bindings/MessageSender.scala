package chrome.runtime.bindings

import scala.scalajs.js

class MessageSender extends js.Object {

  def tab: js.UndefOr[chrome.tabs.Tab] = js.native
  def frameId: js.UndefOr[Int] = js.native
  def id: js.UndefOr[String] = js.native
  def url: js.UndefOr[String] = js.native
  def tlsChannelId: js.UndefOr[String] = js.native

}
