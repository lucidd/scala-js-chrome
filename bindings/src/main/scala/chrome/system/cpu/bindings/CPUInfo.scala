package chrome.system.cpu.bindings

import scala.scalajs.js

@js.native
trait CPUInfo extends js.Object {

  def numOfProcessors: Int = js.native

  def archName: String = js.native

  def modelName: String = js.native

  def features: js.Array[Feature] = js.native

  def processors: js.Array[Processor] = js.native

}
