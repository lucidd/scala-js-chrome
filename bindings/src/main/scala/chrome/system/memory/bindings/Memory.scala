package chrome.system.memory.bindings

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName


@js.native
@JSName("chrome.system.memory")
object Memory extends js.Object {

  def getInfo(callback: js.Function1[MemoryInfo, _]): Unit = js.native

}

