package chrome.tabs.bindings

import scala.scalajs.js

import chrome.windows.bindings.Window

class AttachInfo extends  js.Object {

  def newWindowId: Window.Id = js.native
  def newPosition: Int = js.native

}
