package chrome.system.memory


import chrome.ChromeAPI
import chrome.permissions.APIPermission
import chrome.system.memory.bindings._

import scala.concurrent.{Future, Promise}

object Memory extends ChromeAPI {

  val requiredPermissions: List[APIPermission] = List(APIPermission.System.Memory)

  def getInfo: Future[MemoryInfo] = {
    val promise = Promise[MemoryInfo]()
    bindings.Memory.getInfo((info: MemoryInfo) => {
      promise.complete(chrome.lastErrorOrValue(info))
    })
    promise.future
  }

}


