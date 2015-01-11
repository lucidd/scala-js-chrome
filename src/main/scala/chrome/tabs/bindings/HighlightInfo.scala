package chrome.tabs.bindings

import scala.scalajs.js

import chrome.windows.bindings.Window

class HighlightInfo extends js.Object {

  def windowId: Window.Id = js.native
  def tabIds: js.Array[Tab.Id] = js.native

}
