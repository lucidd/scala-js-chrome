package chrome.app.window.bindings

import org.scalajs.dom

import scala.scalajs.js

class AppWindow extends js.Object {

  def focus(): Unit = js.native

  def fullscreen(): Unit = js.native

  def isFullscreen(): Boolean = js.native

  def minimize(): Unit = js.native

  def isMinimized(): Boolean = js.native

  def maximize(): Unit = js.native

  def isMaximized(): Boolean = js.native

  def restore(): Unit = js.native

  def moveTo(top: Int, left: Int): Unit = js.native

  def resizeTo(width: Int, height: Int): Unit = js.native

  def drawAttention(): Unit = js.native

  def clearAttention(): Unit = js.native

  def close(): Unit = js.native

  def show(focused: js.UndefOr[Boolean] = js.undefined): Unit = js.native

  def hide(): Unit = js.native

  def isAlwaysOnTop(): Boolean = js.native

  def setAlwaysOnTop(alwaysOnTop: Boolean): Unit = js.native

  def setVisibleOnAllWorkspaces(alwaysVisible: Boolean): Unit = js.native

  def contentWindow: dom.Window = js.native

  def id: AppWindow.Id = js.native

  def innerBounds: Bounds = js.native

  def outerBounds: Bounds = js.native

}

object AppWindow {

  type Id = String

}
