package chrome.tabs.bindings

import chrome.windows.bindings.Window

import scala.scalajs.js

object TabCreateProperties {

  def apply(
      windowId: js.UndefOr[Window.Id] = js.undefined,
      index: js.UndefOr[Int] = js.undefined,
      url: js.UndefOr[String] = js.undefined,
      active: js.UndefOr[Boolean] = js.undefined,
      pinned: js.UndefOr[Boolean] = js.undefined,
      openerTabId: js.UndefOr[Tab.Id] = js.undefined
  ): TabCreateProperties = {
    js.Dynamic
      .literal(
        windowId = windowId,
        index = index,
        url = url,
        active = active,
        pinned = pinned,
        openerTabId = openerTabId
      )
      .asInstanceOf[TabCreateProperties]
  }

}

@js.native
trait TabCreateProperties extends js.Object {

  def windowId: js.UndefOr[Window.Id] = js.native

  def index: js.UndefOr[Int] = js.native

  def url: js.UndefOr[String] = js.native

  def active: js.UndefOr[Boolean] = js.native

  def pinned: js.UndefOr[Boolean] = js.native

  def openerTabId: js.UndefOr[Tab.Id] = js.native

}
