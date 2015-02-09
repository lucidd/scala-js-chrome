package chrome.system.network

import chrome.system.network.Interface.Config

case class Interface(val name: String, val configurations: List[Config])

object Interface {

  case class Config(val address: String, val prefixLength: Int)

}
