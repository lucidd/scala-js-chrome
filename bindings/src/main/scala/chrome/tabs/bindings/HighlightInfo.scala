package chrome.tabs.bindings

import chrome.windows.bindings.Window

import scala.scalajs.js

@js.native
trait HighlightInfo extends js.Object {

  def windowId: Window.Id = js.native

  def tabIds: js.Array[Tab.Id] = js.native

}
