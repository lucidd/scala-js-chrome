package chrome.system.memory


import scala.concurrent.{Promise, Future}
import bindings._

object Memory {

  def getInfo: Future[MemoryInfo] = {
    val promise = Promise[MemoryInfo]
    bindings.Memory.getInfo((info: MemoryInfo) => {
      promise.complete(chrome.lastErrorOrValue(info))
    })
    promise.future
  }

}


