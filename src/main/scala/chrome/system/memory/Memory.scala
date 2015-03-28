package chrome.system.memory


import chrome.system.memory.bindings._

import scala.concurrent.{Future, Promise}

object Memory {

  def getInfo: Future[MemoryInfo] = {
    val promise = Promise[MemoryInfo]()
    bindings.Memory.getInfo((info: MemoryInfo) => {
      promise.complete(chrome.lastErrorOrValue(info))
    })
    promise.future
  }

}


