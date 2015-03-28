package chrome.power

import chrome.power.bindings._

object Power {

  def requestKeepAwake(level: Level.Level): Unit = bindings.Power.requestKeepAwake(level)

  def releaseKeepAwake(): Unit = bindings.Power.releaseKeepAwake()

}
