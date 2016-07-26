package chrome.tabs.bindings

import chrome.windows.bindings.Window

import scala.scalajs.js

@js.native
trait DetachInfo extends js.Object {

  def oldWindowId: Window.Id = js.native

  def oldPosition: Int = js.native

}
