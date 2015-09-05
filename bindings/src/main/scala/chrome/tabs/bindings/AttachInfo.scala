package chrome.tabs.bindings

import chrome.windows.bindings.Window

import scala.scalajs.js

@js.native
trait AttachInfo extends js.Object {

  def newWindowId: Window.Id = js.native

  def newPosition: Int = js.native

}
