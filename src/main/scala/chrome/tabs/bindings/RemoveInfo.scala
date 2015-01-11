package chrome.tabs.bindings


import scala.scalajs.js

import chrome.windows.bindings.Window

class RemoveInfo extends js.Object {

  def windowId: Window.Id = js.native
  def isWindowClosing: Boolean = js.native

}
