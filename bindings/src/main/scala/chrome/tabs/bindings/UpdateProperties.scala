package chrome.tabs.bindings


import scala.scalajs.js


object UpdateProperties {

  def apply(url: js.UndefOr[String] = js.undefined,
            active: js.UndefOr[Boolean] = js.undefined,
            highlighted: js.UndefOr[Boolean] = js.undefined,
            pinned: js.UndefOr[Boolean] = js.undefined,
            openerTabId: js.UndefOr[Tab.Id] = js.undefined): UpdateProperties = {
    js.Dynamic.literal(
      url = url,
      active = active,
      highlighted = highlighted,
      pinned = pinned,
      openerTabId = openerTabId
    ).asInstanceOf[UpdateProperties]
  }

}

@js.native
trait UpdateProperties extends js.Object {

  def url: js.UndefOr[String] = js.native

  def active: js.UndefOr[Boolean] = js.native

  def highlighted: js.UndefOr[Boolean] = js.native

  def pinned: js.UndefOr[Boolean] = js.native

  def openerTabId: js.UndefOr[Tab.Id] = js.native

}
