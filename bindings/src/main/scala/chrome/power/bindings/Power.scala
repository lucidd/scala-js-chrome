package chrome.power.bindings

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal("chrome.power")
object Power extends js.Object {

  def requestKeepAwake(level: Level.Level): Unit = js.native

  def releaseKeepAwake(): Unit = js.native

}

object Level {

  type Level = String

  val SYSTEM: Level = "system"
  val DISPLAY: Level = "display"

}
