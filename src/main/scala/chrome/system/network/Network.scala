package chrome.system.network

import scala.concurrent.{Promise, Future}
import scala.scalajs.js

import bindings._

object Network {

  def getNetworkInterfaces: Future[List[NetworkInterface]] = {
    val promise = Promise[List[NetworkInterface]]
    bindings.Network.getNetworkInterfaces((interfaces: js.Array[NetworkInterface]) => {
      promise.complete(chrome.lastErrorOrValue(interfaces.toList))
    })
    promise.future
  }
  
}
