package chrome.runtime.bindings

import scala.scalajs.js

@js.native
trait App extends js.Object {
  val background: Background = js.native
}

@js.native
trait Background extends js.Object {
  val scripts: js.Array[String] = js.native
}

@js.native
trait AppManifest extends Manifest {
  val app: App = js.native
}

@js.native
trait ExtensionManifest extends Manifest {
  val background: js.UndefOr[Background] = js.native
}

@js.native
trait Manifest extends js.Object {

  val name: String = js.native
  val version: String = js.native
  val manifest_version: Int = js.native
  val defaultLocale: js.UndefOr[String] = js.native
  val shortName: js.UndefOr[String] = js.native
  val description: js.UndefOr[String] = js.native
  val offlineEnabled: js.UndefOr[Boolean] = js.native
  val permissions: js.UndefOr[js.Array[String]] = js.native
  val icons: js.UndefOr[Map[String, String]] = js.native

}

object Manifest {

  implicit class ManifestOps(val manifest: Manifest) extends AnyVal {

    def isAppManifest: Boolean = manifest.hasOwnProperty("app")

    def isExtensionManifest: Boolean = !isAppManifest

    def asAppManifest: Option[AppManifest] = {
      if (isAppManifest) {
        Some(manifest.asInstanceOf[AppManifest])
      } else None
    }

    def asExtensionManifest: Option[ExtensionManifest] = {
      if (isExtensionManifest) {
        Some(manifest.asInstanceOf[ExtensionManifest])
      } else None
    }
  }


}
