package chrome.system.network

import chrome.ChromeAPI
import chrome.permissions.Permission.{Host, API}
import chrome.utils.ErrorHandling._

import scala.concurrent.{Future, Promise}
import scala.scalajs.js

object Network extends ChromeAPI {

  val requiredPermissions: Set[API] = Set(API.System.Network)

  def getNetworkInterfaces: Future[List[Interface]] = {
    val promise = Promise[List[Interface]]()
    bindings.Network.getNetworkInterfaces(
        (interfaces: js.Array[bindings.NetworkInterface]) => {
      promise.complete(lastErrorOrValue {
        (for ((name, interfaces) <- interfaces.groupBy(_.name)) yield {
          val configs = interfaces.map(x =>
                new Interface.Config(x.address, x.prefixLength))
          new Interface(name, configs.toList)
        }).toList
      })
    })
    promise.future
  }

}
