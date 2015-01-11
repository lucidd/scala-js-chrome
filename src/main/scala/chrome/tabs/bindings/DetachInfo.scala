package chrome.tabs.bindings


import scala.scalajs.js

import chrome.windows.bindings.Window

class DetachInfo extends  js.Object {

  def oldWindowId: Window.Id = js.native
  def oldPosition: Int = js.native

}
