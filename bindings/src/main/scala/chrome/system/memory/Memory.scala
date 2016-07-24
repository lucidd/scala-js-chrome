package chrome.system.memory


import chrome.ChromeAPI
import chrome.permissions.APIPermission
import chrome.system.memory.bindings._
import chrome.utils.ErrorHandling._

import scala.concurrent.{Future, Promise}

object Memory extends ChromeAPI {

  val requiredPermissions: Set[APIPermission] = Set(APIPermission.System.Memory)

  def getInfo: Future[MemoryInfo] = {
    val promise = Promise[MemoryInfo]()
    bindings.Memory.getInfo((info: MemoryInfo) => {
      promise.complete(lastErrorOrValue(info))
    })
    promise.future
  }

}


