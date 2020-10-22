package chrome.app.window

import chrome.app.window.bindings._
import chrome.events.EventSource
import chrome.events.EventSourceImplicits._
import chrome.utils.ErrorHandling._

import scala.concurrent.{Future, Promise}
import scala.scalajs.js

object Window {

  val onBoundsChanged: EventSource[Unit] = bindings.Window.onBoundsChanged
  val onClosed: EventSource[Unit] = bindings.Window.onClosed
  val onFullscreened: EventSource[Unit] = bindings.Window.onFullscreened
  val onMaximized: EventSource[Unit] = bindings.Window.onMaximized
  val onMinimized: EventSource[Unit] = bindings.Window.onMinimized
  val onRestored: EventSource[Unit] = bindings.Window.onRestored

  def current: AppWindow = bindings.Window.current()

  def create(url: String, options: js.UndefOr[CreateWindowOptions] = js.undefined): Future[AppWindow] = {
    val promise = Promise[AppWindow]()
    bindings.Window
      .create(
        url,
        options,
        js.Any.fromFunction1((appWindow: AppWindow) => {
          promise.complete(lastErrorOrValue(appWindow))
        })
      )
    promise.future
  }

  def getAll: js.Array[AppWindow] = bindings.Window.getAll()

  def get(id: AppWindow.Id): AppWindow = bindings.Window.get(id)

  def canSetVisibleOnAllWorkspaces: Boolean =
    bindings.Window.canSetVisibleOnAllWorkspaces()

}
