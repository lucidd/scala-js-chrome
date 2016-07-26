package chrome.power

import chrome.ChromeAPI
import chrome.permissions.Permission.{Host, API}
import chrome.power.bindings._

object Power extends ChromeAPI {

  val requiredPermissions: Set[API] = Set(API.Power)

  def requestKeepAwake(level: Level.Level): Unit =
    bindings.Power.requestKeepAwake(level)

  def releaseKeepAwake(): Unit = bindings.Power.releaseKeepAwake()

}
