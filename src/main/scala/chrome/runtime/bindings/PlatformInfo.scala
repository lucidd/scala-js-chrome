package chrome.runtime.bindings

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName


object PlatformInfo {

  type OperatingSystem = String
  type Architecture = String

  object OperatingSystems {

    val MAC: OperatingSystem = "mac"
    val WIN: OperatingSystem = "win"
    val ANDROID: OperatingSystem = "android"
    val CROS: OperatingSystem = "cros"
    val LINUX: OperatingSystem = "linux"
    val OPENBSD: OperatingSystem = "openbsd"

  }

  object Architectures {

    val ARM: OperatingSystem = "arm"
    val X86_32: OperatingSystem = "x86-32"
    val X86_64: OperatingSystem = "x86-64"

  }

}

class PlatformInfo extends js.Object {

  def os: PlatformInfo.OperatingSystem = js.native

  def arch: PlatformInfo.Architecture = js.native

  @JSName("nacl_arch")
  def naclArch: PlatformInfo.Architecture = js.native


}
