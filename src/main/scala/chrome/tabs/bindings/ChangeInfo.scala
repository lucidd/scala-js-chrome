package chrome.tabs.bindings

import scala.scalajs.js


class ChangeInfo extends js.Object {

  def status: js.UndefOr[Tab.Status] = js.native

  def url: js.UndefOr[String] = js.native

  def pinned: js.UndefOr[Boolean] = js.native

  def favIconUrl: js.UndefOr[String] = js.native

}
