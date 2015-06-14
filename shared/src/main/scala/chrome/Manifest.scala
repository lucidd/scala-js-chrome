package chrome

import chrome.permissions.{HostPermission, APIPermission, Permission}


trait Manifest {
  val name: String
  val version: String
  val manifestVersion: Int
  val shortName: Option[String]
  val defaultLocale: Option[String]
  val description: Option[String]
  val offlineEnabled: Boolean
  val permissions: Set[Permission]
  val icons: Map[Int, String]
}

trait Background {
  val scripts: List[String]
}

trait App {
  val background: Background
}

trait AppManifest extends Manifest {
  val app: App
}

trait ExtensionManifest extends Manifest {
  val background: Background
}



object Impl {

  case class Background(scripts: List[String]) extends chrome.Background

  case class App(background: Background) extends chrome.App

  case class AppManifest(name: String,
                         version: String,
                         app: App,
                         manifestVersion: Int,
                         shortName: Option[String] = None,
                         defaultLocale: Option[String] = None,
                         description: Option[String] = None,
                         offlineEnabled: Boolean = true,
                         permissions: Set[Permission] = Set(),
                         icons: Map[Int, String] = Map()
                          ) extends chrome.AppManifest

  case class ExtensionManifest(name: String,
                               version: String,
                               manifestVersion: Int,
                               background: Background,
                               shortName: Option[String] = None,
                               defaultLocale: Option[String],
                               description: Option[String],
                               offlineEnabled: Boolean = true,
                               permissions: Set[Permission],
                               icons: Map[Int, String]
                                ) extends chrome.ExtensionManifest

}
