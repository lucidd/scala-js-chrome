package chrome.windows.bindings

import chrome.sessions.bindings.Session
import chrome.tabs.bindings.Tab

import scala.scalajs.js

class Window extends js.Object {

  val id: js.UndefOr[Window.Id] = js.native
  val focused: Boolean = js.native
  val top: js.UndefOr[Int] = js.native
  val left: js.UndefOr[Int] = js.native
  val width: js.UndefOr[Int] = js.native
  val height: js.UndefOr[Int] = js.native
  val tabs: js.UndefOr[js.Array[Tab]] = js.native
  val incognito: Boolean = js.native
  val `type`: js.UndefOr[Window.Type] = js.native
  val state: js.UndefOr[Window.State] = js.native
  val alwaysOnTop: Boolean = js.native
  val sessionId: js.UndefOr[Session.Id] = js.native

}

object Window {

  type Id = Int
  type Type = String
  type State = String
  type CreateType = String

  object Type {
    val NORMAL: Type = "normal"
    val POPUP: Type = "popup"
    val PANEL: Type = "panel"
    val APP: Type = "app"
  }

  object State {
    val NORMAL: State = "normal"
    val MINIMIZED: State = "minimized"
    val MAXIMIZED: State = "maximized"
    val FULLSCREEN: State = "fullscreen"
  }

  object CreateType {
    val NORMAL: CreateType = "normal"
    val POPUP: CreateType = "popup"
    val PANEL: CreateType = "panel"
    val DETACHED_PANEL: CreateType = "detached_panel"
  }

}
