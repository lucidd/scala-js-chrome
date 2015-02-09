package chrome.app.window.bindings

import chrome.events.bindings.Event

import scala.concurrent.{Future, Promise}
import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.{Any, Function1}

@JSName("chrome.app.window")
object Window extends js.Object {

  def current(): AppWindow = js.native

  def create(url: String, options: js.UndefOr[CreateWindowOptions] = js.undefined, callback: js.UndefOr[Function1[AppWindow, _]] = js.undefined): Unit = js.native

  def getAll(): js.Array[AppWindow] = js.native

  def get(id: AppWindow.Id): AppWindow = js.native

  def canSetVisibleOnAllWorkspaces(): Boolean = js.native

  val onBoundsChanged: Event[js.Function0[_]] = js.native
  val onClosed: Event[js.Function0[_]] = js.native
  val onFullscreened: Event[js.Function0[_]] = js.native
  val onMaximized: Event[js.Function0[_]] = js.native
  val onMinimized: Event[js.Function0[_]] = js.native
  val onRestored: Event[js.Function0[_]] = js.native

}