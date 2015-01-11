package chrome.tabs.bindings


import scala.scalajs.js

import chrome.windows.bindings.Window

class MoveInfo extends  js.Object {

  def windowId: Window.Id = js.native
  def fromIndex: Int = js.native
  def toIndex: Int = js.native

}
