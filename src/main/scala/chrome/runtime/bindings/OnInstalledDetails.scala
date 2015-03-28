package chrome.runtime.bindings

import scala.scalajs.js


object OnInstalledDetails {

  type InstallReason = String

  object InstallReasons {

    val INSTALL: InstallReason = "install"
    val UPDATE: InstallReason = "update"
    val CHROME_UPDATE: InstallReason = "chrome_update"
    val SHARED_MODULE_UPDATE: InstallReason = "shared_module_update"

  }

}

class OnInstalledDetails extends js.Object {

  val reason: OnInstalledDetails.InstallReason = js.native
  val previousVersion: js.UndefOr[String] = js.native
  val id: js.UndefOr[String] = js.native

}
