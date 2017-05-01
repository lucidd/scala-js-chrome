package chrome.app.window.bindings

import chrome.events.bindings.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.{UndefOr, native, undefined}

@js.native
@JSGlobal("chrome.app.window")
object Window extends js.Object {

  val onBoundsChanged: Event[js.Function0[_]] = native
  val onClosed: Event[js.Function0[_]] = native
  val onFullscreened: Event[js.Function0[_]] = native
  val onMaximized: Event[js.Function0[_]] = native
  val onMinimized: Event[js.Function0[_]] = native
  val onRestored: Event[js.Function0[_]] = native

  def current(): AppWindow = native

  def create(url: String,
             options: UndefOr[CreateWindowOptions] = undefined,
             callback: UndefOr[js.Function1[AppWindow, _]] = undefined): Unit =
    native

  def getAll(): js.Array[AppWindow] = native

  def get(id: AppWindow.Id): AppWindow = native

  def canSetVisibleOnAllWorkspaces(): Boolean = native

}
