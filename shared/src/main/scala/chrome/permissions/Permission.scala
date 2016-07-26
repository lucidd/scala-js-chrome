package chrome.permissions

sealed trait Permission

case class HostPermission(urlPattern: String) extends Permission
case class APIPermission(name: String) extends Permission

object APIPermission {

  val ActiveTab = APIPermission("activeTab")
  val Alarms = APIPermission("alarms")
  val Audio = APIPermission("audio")
  val AudioCapture = APIPermission("audioCapture")
  val AudioModem = APIPermission("audioModem")
  val Background = APIPermission("background")
  val Bookmarks = APIPermission("bookmarks")
  val Browser = APIPermission("browser")
  val BrowsingData = APIPermission("browsingData")
  val ClipboardRead = APIPermission("clipboardRead")
  val ClipboardWrite = APIPermission("clipboardWrite")
  val ContentSettings = APIPermission("contentSettings")
  val ContextMenus = APIPermission("contextMenus")
  val Cookies = APIPermission("cookies")
  val Copresence = APIPermission("copresence")
  val Debugger = APIPermission("debugger")
  val DeclarativeContent = APIPermission("declarativeContent")
  val DeclarativeWebRequest = APIPermission("declarativeWebRequest")
  val DesktopCapture = APIPermission("desktopCapture")
  val Diagnostics = APIPermission("diagnostics")
  val DNS = APIPermission("dns")
  val DocumentScan = APIPermission("documentScan")
  val Downloads = APIPermission("downloads")
  object Enterprise {
    val PlatformKeys = APIPermission("enterprise.platformKeys")
  }
  val Experimental = APIPermission("experimental")
  val FileBrowserHandler = APIPermission("fileBrowserHandler")
  val FileSystemProvider = APIPermission("fileSystemProvider")
  val FontSettings = APIPermission("fontSettings")
  val GCM = APIPermission("gcm")
  val Geolocation = APIPermission("geolocation")
  val History = APIPermission("history")
  val Identity = APIPermission("identity")
  val Idle = APIPermission("idle")
  val Idltest = APIPermission("idltest")
  val Location = APIPermission("location")
  val Management = APIPermission("management")
  val NativeMessaging = APIPermission("nativeMessaging")
  object Networking {
    val Config = APIPermission("networking.config")
  }
  val NotificationProvider = APIPermission("notificationProvider")
  val Notifications = APIPermission("notifications")
  val PageCapture = APIPermission("pageCapture")
  val PlatformKeys = APIPermission("platformKeys")
  val Power = APIPermission("power")
  val PrinterProvider = APIPermission("printerProvider")
  val Privacy = APIPermission("privacy")
  val Processes = APIPermission("processes")
  val Proxy = APIPermission("proxy")
  val Sessions = APIPermission("sessions")
  val SignedInDevices = APIPermission("signedInDevices")
  val Storage = APIPermission("storage")
  object System {
    val CPU = APIPermission("system.cpu")
    val Display = APIPermission("system.display")
    val Memory = APIPermission("system.memory")
    val Network = APIPermission("system.network")
    val Storage = APIPermission("system.storage")
  }
  val TabCapture = APIPermission("tabCapture")
  val Tabs = APIPermission("tabs")
  val TopSites = APIPermission("topSites")
  val TTS = APIPermission("tts")
  val TTSEngine = APIPermission("ttsEngine")
  val UnlimitedStorage = APIPermission("unlimitedStorage")
  val VideoCapture = APIPermission("videoCapture")
  val VpnProvider = APIPermission("vpnProvider")
  val Wallpaper = APIPermission("wallpaper")
  val Webview = APIPermission("webview")
  val WebNavigation = APIPermission("webNavigation")
  val WebRequest = APIPermission("webRequest")
  val WebRequestBlocking = APIPermission("webRequestBlocking")
  val FileSystem = APIPermission("fileSystem")
  val HID = APIPermission("hid")
  val MDNS = APIPermission("mdns")
  val MediaGalleries = APIPermission("mediaGalleries")
  val PointerLock = APIPermission("pointerLock")
  val Serial = APIPermission("serial")
  val Socket = APIPermission("socket")
  val SyncFileSystem = APIPermission("syncFileSystem")
  val USB = APIPermission("usb")

  val All: Map[String, APIPermission] = Set(
      ActiveTab,
      Alarms,
      Audio,
      AudioCapture,
      AudioModem,
      Background,
      Bookmarks,
      Browser,
      BrowsingData,
      ClipboardRead,
      ClipboardWrite,
      ContentSettings,
      ContextMenus,
      Cookies,
      Copresence,
      Debugger,
      DeclarativeContent,
      DeclarativeWebRequest,
      DesktopCapture,
      Diagnostics,
      DNS,
      DocumentScan,
      Downloads,
      PlatformKeys,
      Experimental,
      FileBrowserHandler,
      FileSystemProvider,
      FontSettings,
      GCM,
      Geolocation,
      History,
      Identity,
      Idle,
      Idltest,
      Location,
      Management,
      NativeMessaging,
      Networking.Config,
      NotificationProvider,
      Notifications,
      PageCapture,
      PlatformKeys,
      Power,
      PrinterProvider,
      Privacy,
      Processes,
      Proxy,
      Sessions,
      SignedInDevices,
      Storage,
      System.CPU,
      System.Display,
      System.Memory,
      System.Network,
      Storage,
      TabCapture,
      Tabs,
      TopSites,
      TTS,
      TTSEngine,
      UnlimitedStorage,
      VideoCapture,
      VpnProvider,
      Wallpaper,
      Webview,
      WebNavigation,
      WebRequest,
      WebRequestBlocking,
      FileSystem,
      HID,
      MDNS,
      MediaGalleries,
      PointerLock,
      Serial,
      Socket,
      SyncFileSystem,
      USB
  ).map(x => x.name -> x).toMap

}
