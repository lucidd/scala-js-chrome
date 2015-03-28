package chrome.system.network

import chrome.system.network.Interface.Config

case class Interface(name: String, configurations: List[Config])

object Interface {

  case class Config(address: String, prefixLength: Int)

}
