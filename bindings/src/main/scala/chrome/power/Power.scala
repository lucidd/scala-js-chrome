package chrome.power

import chrome.ChromeAPI
import chrome.permissions.APIPermission
import chrome.power.bindings._

object Power extends ChromeAPI {

  val requiredPermissions: Set[APIPermission] = Set(APIPermission.Power)

  def requestKeepAwake(level: Level.Level): Unit = bindings.Power.requestKeepAwake(level)

  def releaseKeepAwake(): Unit = bindings.Power.releaseKeepAwake()

}
