package chrome.system.network.bindings

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal("chrome.system.network")
object Network extends js.Object {

  def getNetworkInterfaces(
      callback: js.Function1[js.Array[NetworkInterface], _]): Unit = js.native

}
