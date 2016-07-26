package chrome.system.cpu.bindings

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
@JSName("chrome.system.cpu")
object CPU extends js.Object {

  def getInfo(callback: js.Function1[CPUInfo, _]): Unit = js.native

}
