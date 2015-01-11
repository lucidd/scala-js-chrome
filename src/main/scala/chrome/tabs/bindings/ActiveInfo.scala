package chrome.tabs.bindings

import scala.scalajs.js

import chrome.windows.bindings.Window

class ActiveInfo extends js.Object {

  def tabId: Tab.Id = js.native
  def windowId: Window.Id = js.native

}
