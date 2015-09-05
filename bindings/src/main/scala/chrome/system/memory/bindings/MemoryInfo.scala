package chrome.system.memory.bindings

import scala.scalajs.js

@js.native
trait MemoryInfo extends js.Object {

  def capacity: Double = js.native

  def availableCapacity: Double = js.native

}

