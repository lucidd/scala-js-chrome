package chrome.runtime.bindings

import chrome.tabs.bindings.Tab

import scala.scalajs.js

class MessageSender extends js.Object {

  def tab: js.UndefOr[Tab] = js.native
  def frameId: js.UndefOr[Int] = js.native
  def id: js.UndefOr[String] = js.native
  def url: js.UndefOr[String] = js.native
  def tlsChannelId: js.UndefOr[String] = js.native

}
