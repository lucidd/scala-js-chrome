package chrome.tabs.bindings

import chrome.windows.bindings.Window

import scala.scalajs.js

class ActiveInfo extends js.Object {

  def tabId: Tab.Id = js.native

  def windowId: Window.Id = js.native

}
