package chrome.tabs.bindings


import scala.scalajs.js

@js.native
trait ZoomChangeInfo extends js.Object {

  def tabId: Tab.Id = js.native

  def oldZoomFactor: Double = js.native

  def newZoomFactor: Double = js.native

  def zoomSettings: ZoomSettings = js.native

}
