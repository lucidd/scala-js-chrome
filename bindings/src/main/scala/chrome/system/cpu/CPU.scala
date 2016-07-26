package chrome.system.cpu

import chrome.ChromeAPI
import chrome.permissions.Permission.{Host, API}
import chrome.system.cpu.bindings._
import chrome.utils.ErrorHandling._

import scala.concurrent.{Future, Promise}

object CPU extends ChromeAPI {

  val requiredPermissions: Set[API] = Set(API.System.CPU)

  def getInfo: Future[CPUInfo] = {
    val promise = Promise[CPUInfo]()
    bindings.CPU.getInfo((info: CPUInfo) => {
      promise.complete(lastErrorOrValue(info))
    })
    promise.future
  }

}
