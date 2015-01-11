package chrome.tabs.bindings


import scala.scalajs.js

import chrome.windows.bindings.Window

class ReloadProperties extends js.Object {

  def bypassCache: js.UndefOr[Boolean] = js.native

}

object ReloadProperties {

  def apply(bypassCache: js.UndefOr[Boolean] = js.undefined): ReloadProperties = {
    js.Dynamic.literal(
      bypassCache = bypassCache
    ).asInstanceOf[ReloadProperties]
  }

}