package chrome.tabs.bindings

import chrome.windows.bindings.Window

import scala.scalajs.js


class TabQuery extends js.Object {

  def active: js.UndefOr[Boolean] = js.native

  def pinned: js.UndefOr[Boolean] = js.native

  def highlighted: js.UndefOr[Boolean] = js.native

  def currentWindow: js.UndefOr[Boolean] = js.native

  def lastFocusedWindow: js.UndefOr[Boolean] = js.native

  def status: js.UndefOr[Tab.Status] = js.native

  def title: js.UndefOr[String] = js.native

  def url: js.UndefOr[js.Any] = js.native

  def windowId: js.UndefOr[Window.Id] = js.native

  def windowType: js.UndefOr[Window.Type] = js.native

  def index: js.UndefOr[Int] = js.native

}

object TabQuery {

  def apply(active: js.UndefOr[Boolean] = js.undefined,
            pinned: js.UndefOr[Boolean] = js.undefined,
            highlighted: js.UndefOr[Boolean] = js.undefined,
            currentWindow: js.UndefOr[Boolean] = js.undefined,
            lastFocusedWindow: js.UndefOr[Boolean] = js.undefined,
            status: js.UndefOr[Tab.Status] = js.undefined,
            title: js.UndefOr[String] = js.undefined,
            url: js.UndefOr[js.Any] = js.undefined,
            windowId: js.UndefOr[Window.Id] = js.undefined,
            windowType: js.UndefOr[Window.Type] = js.undefined,
            index: js.UndefOr[Int] = js.undefined
             ): TabQuery = {
    js.Dynamic.literal(
      active = active,
      pinned = pinned,
      highlighted = highlighted,
      currentWindow = currentWindow,
      lastFocusedWindow = lastFocusedWindow,
      status = status,
      title = title,
      url = url,
      windowId = windowId,
      windowType = windowType,
      index = index
    ).asInstanceOf[TabQuery]
  }

}
