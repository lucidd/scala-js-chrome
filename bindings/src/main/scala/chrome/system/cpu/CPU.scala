package chrome.system.cpu


import chrome.ChromeAPI
import chrome.permissions.APIPermission
import chrome.system.cpu.bindings._
import utils.ErrorHandling.lastErrorOrValue

import scala.concurrent.{Future, Promise}

object CPU extends ChromeAPI {

  val requiredPermissions: Set[APIPermission] = Set(APIPermission.System.CPU)

  def getInfo: Future[CPUInfo] = {
    val promise = Promise[CPUInfo]()
    bindings.CPU.getInfo((info: CPUInfo) => {
      promise.complete(lastErrorOrValue(info))
    })
    promise.future
  }

}
