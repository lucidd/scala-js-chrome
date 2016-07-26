package chrome

import chrome.permissions.Permission

sealed trait Manifest {
  val name: String
  val version: String
  val manifestVersion: Int = 2
  val shortName: Option[String] = None
  val defaultLocale: Option[String] = None
  val description: Option[String] = None
  val offlineEnabled: Option[Boolean] = None
  val permissions: Set[Permission] = Set()
  val optionalPermissions: Set[Permission] = Set()
  val icons: Map[Int, String] = Map.empty
  val minimumChromeVersion: Option[String] = None
  val author: Option[String] = None
  val commands: Option[Commands] = None
  val key: Option[String] = None
  val storage: Option[Storage] = None
  val updateUrl: Option[String] = None
  val versionName: Option[String] = None
  val platforms: List[Platform] = Nil
  val externallyConnectable: Option[ExternallyConnectable] = None
}

case class Background(scripts: List[String])
case class App(background: Background)

case class BrowserAction(
    icon: Map[Int, String] = Map.empty,
    title: Option[String] = None,
    popup: Option[String] = None
)
case class Bluetooth(
    uuids: List[String] = Nil,
    socket: Option[Boolean] = None,
    lowEnergy: Option[Boolean] = None,
    peripheral: Option[Boolean] = None
)

case class Requirements(webgl: Option[Boolean] = None, npapi: Option[Boolean] = None)
case class Omnibox(keyword: String)
case class Storage(managedSchema: String)

case class ChromeUIOverrides(bookmarksUI: BookmarksUI)
case class BookmarksUI(
    removeButton: Option[Boolean] = None,
    removeBookmarkShortcut: Option[Boolean] = None
)

case class Platform(
    naclArch: String,
    subPackagePath: String
)

case class OptionsUI(
    page: String,
    chromeStyle: Option[Boolean] = None
)

case class ExternallyConnectable(
    matches: Set[String],
    ids: Set[String],
    acceptsTlsChannelId: Option[Boolean]
)

case class Commands(actions: Map[String, Commands.Action] = Map.empty)
object Commands {
  case class Action(
      suggestedKey: SuggestedKey,
      description: Option[String] = None,
      global: Option[Boolean] = None
  )
  case class SuggestedKey(
      default: Option[String] = None,
      linux: Option[String] = None,
      chromeos: Option[String] = None,
      mac: Option[String] = None,
      windows: Option[String] = None
  )
  val ExecuteBrowserAction = "_execute_browser_action"
  val ExecutePageAction = "_execute_page_action"
}

trait AppManifest extends chrome.Manifest {
  val app: chrome.App
  val sockets: Option[Sockets] = None
  val bluetooth: Option[Bluetooth] = None
  val kioskEnabled: Option[Boolean] = None
  val kioskOnly: Option[Boolean] = None
}


trait ExtensionManifest extends chrome.Manifest {
  val background: Background
  val browserAction: Option[BrowserAction] = None
  val omnibox: Option[Omnibox] = None
  val optionsUI: Option[OptionsUI] = None
  val chromeUIOverrides: Option[ChromeUIOverrides] = None
}
