package chrome.tabs.bindings


import scala.scalajs.js

class ZoomSettings extends js.Object {

  def mode: js.UndefOr[ZoomSettings.Mode] = js.native
  def scope: js.UndefOr[ZoomSettings.Scope] = js.native

}

object ZoomSettings {

  type Mode = String
  
  object Modes {
    val AUTOMATIC: Mode = "automatic"
    val MANUAL: Mode = "manual"
    val DISABLED: Mode = "disabled"
  }

  type Scope = String

  object Scopes {
    val PER_ORIGIN: Mode = "per-origin"
    val PER_TAB: Mode = "per-tab"
  }
  
  def apply(mode: js.UndefOr[ZoomSettings.Mode] = js.undefined,
            scope: js.UndefOr[ZoomSettings.Scope] = js.undefined): ZoomSettings = {
    js.Dynamic.literal(
      mode = mode,
      scope = scope
    ).asInstanceOf[ZoomSettings]
  }

}