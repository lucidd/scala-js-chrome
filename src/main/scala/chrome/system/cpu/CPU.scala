package chrome.system.cpu


import scala.concurrent.{Promise, Future}
import scala.scalajs.js
import bindings._

object CPU {

  def getInfo: Future[CPUInfo] = {
    val promise = Promise[CPUInfo]
    bindings.CPU.getInfo((info: CPUInfo) => {
      promise.complete(chrome.lastErrorOrValue(info))
    })
    promise.future
  }

}