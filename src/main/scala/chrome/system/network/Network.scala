package chrome.system.network

import scala.concurrent.{Future, Promise}
import scala.scalajs.js

object Network {

  def getNetworkInterfaces: Future[List[Interface]] = {
    val promise = Promise[List[Interface]]()
    bindings.Network.getNetworkInterfaces((interfaces: js.Array[bindings.NetworkInterface]) => {
      promise.complete(chrome.lastErrorOrValue {
        (for ((name, interfaces) <- interfaces.groupBy(_.name)) yield {
          val configs = interfaces.map(x => new Interface.Config(x.address, x.prefixLength))
          new Interface(name, configs.toList)
        }).toList
      })
    })
    promise.future
  }

}
