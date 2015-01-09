package chrome.system.display.bindings


import scala.scalajs.js

class DisplayInfo extends js.Object {

  def id: Display.ID = js.native
  def name: String = js.native
  def mirroringSourceId: Display.ID = js.native
  def isPrimary: Boolean = js.native
  def isInternal: Boolean = js.native
  def isEnabled: Boolean = js.native
  def dpiX: Double = js.native
  def dpiY: Double = js.native
  def rotation: Int = js.native
  def bounds: Bounds = js.native
  def overscan: Insets = js.native
  def workArea: Bounds = js.native

}
