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
  val oauth2: Option[Oauth2Settings] = None
  val webAccessibleResources: List[String] = Nil
  val contentSecurityPolicy: Option[String] = None
}

case class Background(scripts: List[String], persistent: Option[Boolean] = None)
case class App(background: Background)

case class BrowserAction(
    icon: Map[Int, String] = Map.empty,
    title: Option[String] = None,
    popup: Option[String] = None
)

case class PageAction(
    icon: Map[Int, String] = Map.empty,
    title: Option[String] = None,
    popup: Option[String] = None
)

case class ContentScript(
    matches: List[String],
    css: List[String],
    js: List[String],
    run_at: Option[ContentScript.RunAt] = None
)

object ContentScript {
  sealed abstract class RunAt(val name: String)

  object RunAt {
    final case object DocumentIdle extends RunAt("document_idle")
    final case object DocumentStart extends RunAt("document_start")
    final case object DocumentEnd extends RunAt("document_end")
  }
}

case class Bluetooth(
    uuids: List[String] = Nil,
    socket: Option[Boolean] = None,
    lowEnergy: Option[Boolean] = None,
    peripheral: Option[Boolean] = None
)

case class Requirements(webgl: Option[Boolean] = None, npapi: Option[Boolean] = None)
case class Omnibox(keyword: String)
case class Storage(managedSchema: String)

case class ChromeUrlOverrides(bookmarks: Option[String] = None, history: Option[String] = None, newtab: Option[String])
case class ChromeUIOverrides(newtab: String, bookmarksUI: BookmarksUI)
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

case class Oauth2Settings(clientId: String, scopes: List[String])

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
  val pageAction: Option[PageAction] = None
  val omnibox: Option[Omnibox] = None
  val optionsUI: Option[OptionsUI] = None
  val chromeUIOverrides: Option[ChromeUIOverrides] = None
  val chromeUrlOverrides: Option[ChromeUrlOverrides] = None
  val contentScripts: List[ContentScript] = List.empty
}
