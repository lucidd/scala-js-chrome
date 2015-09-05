package chrome.alarms.bindings

import scala.scalajs.js

@js.native
trait Alarm extends js.Object {

  def name: String = js.native
  def scheduledTime: Double = js.native
  def periodInMinutes: js.UndefOr[Double] = js.native

}
