package chrome.system.cpu


import chrome.system.cpu.bindings._

import scala.concurrent.{Future, Promise}

object CPU {

  def getInfo: Future[CPUInfo] = {
    val promise = Promise[CPUInfo]()
    bindings.CPU.getInfo((info: CPUInfo) => {
      promise.complete(chrome.lastErrorOrValue(info))
    })
    promise.future
  }

}
