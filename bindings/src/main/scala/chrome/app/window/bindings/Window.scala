package chrome.app.window.bindings

import chrome.events.bindings.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.{UndefOr, undefined}

@js.native
@JSGlobal("chrome.app.window")
object Window extends js.Object {

  val onBoundsChanged: Event[js.Function0[_]] = js.native
  val onClosed: Event[js.Function0[_]] = js.native
  val onFullscreened: Event[js.Function0[_]] = js.native
  val onMaximized: Event[js.Function0[_]] = js.native
  val onMinimized: Event[js.Function0[_]] = js.native
  val onRestored: Event[js.Function0[_]] = js.native

  def current(): AppWindow = js.native

  def create(
      url: String,
      options: UndefOr[CreateWindowOptions] = undefined,
      callback: UndefOr[js.Function1[AppWindow, _]] = undefined
  ): Unit =
    js.native

  def getAll(): js.Array[AppWindow] = js.native

  def get(id: AppWindow.Id): AppWindow = js.native

  def canSetVisibleOnAllWorkspaces(): Boolean = js.native

}
