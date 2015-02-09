package chrome.app.window

import bindings._
import chrome.events.bindings.Event

import scala.concurrent.{Promise, Future}
import scala.scalajs.js


object Window {

  def current: AppWindow = bindings.Window.current()

  def create(url: String, options: js.UndefOr[CreateWindowOptions] = js.undefined): Future[AppWindow] = {
    val promise = Promise[AppWindow]
    bindings.Window.create(url, options, js.Any.fromFunction1((appWindow: AppWindow) => {
      promise.complete(chrome.lastErrorOrValue(appWindow))
    }))
    promise.future
  }

  def getAll: js.Array[AppWindow] = bindings.Window.getAll()

  def get(id: AppWindow.Id): AppWindow = bindings.Window.get(id)

  def canSetVisibleOnAllWorkspaces: Boolean = bindings.Window.canSetVisibleOnAllWorkspaces()

  val onBoundsChanged: Event[js.Function0[_]] = bindings.Window.onBoundsChanged
  val onClosed: Event[js.Function0[_]] = bindings.Window.onClosed
  val onFullscreened: Event[js.Function0[_]] = bindings.Window.onFullscreened
  val onMaximized: Event[js.Function0[_]] = bindings.Window.onMaximized
  val onMinimized: Event[js.Function0[_]] = bindings.Window.onMinimized
  val onRestored: Event[js.Function0[_]] = bindings.Window.onRestored
  
}
