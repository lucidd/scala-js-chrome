package chrome.permissions

sealed trait Permission
object Permission {
  case class Host(urlPattern: String) extends Permission
  case class API(name: String) extends Permission
  object API {

    val ActiveTab = API("activeTab")
    val Alarms = API("alarms")
    val Audio = API("audio")
    val AudioCapture = API("audioCapture")
    val AudioModem = API("audioModem")
    val Background = API("background")
    val Bookmarks = API("bookmarks")
    val Browser = API("browser")
    val BrowsingData = API("browsingData")
    val ClipboardRead = API("clipboardRead")
    val ClipboardWrite = API("clipboardWrite")
    val ContentSettings = API("contentSettings")
    val ContextMenus = API("contextMenus")
    val Cookies = API("cookies")
    val Copresence = API("copresence")
    val Debugger = API("debugger")
    val DeclarativeContent = API("declarativeContent")
    val DeclarativeWebRequest = API("declarativeWebRequest")
    val DesktopCapture = API("desktopCapture")
    val Diagnostics = API("diagnostics")
    val DNS = API("dns")
    val DocumentScan = API("documentScan")
    val Downloads = API("downloads")
    object Enterprise {
      val PlatformKeys = API("enterprise.platformKeys")
    }
    val Experimental = API("experimental")
    val FileBrowserHandler = API("fileBrowserHandler")
    val FileSystemProvider = API("fileSystemProvider")
    val FontSettings = API("fontSettings")
    val GCM = API("gcm")
    val Geolocation = API("geolocation")
    val History = API("history")
    val Identity = API("identity")
    val Idle = API("idle")
    val Idltest = API("idltest")
    val Location = API("location")
    val Management = API("management")
    val NativeMessaging = API("nativeMessaging")
    object Networking {
      val Config = API("networking.config")
    }
    val NotificationProvider = API("notificationProvider")
    val Notifications = API("notifications")
    val PageCapture = API("pageCapture")
    val PlatformKeys = API("platformKeys")
    val Power = API("power")
    val PrinterProvider = API("printerProvider")
    val Privacy = API("privacy")
    val Processes = API("processes")
    val Proxy = API("proxy")
    val Sessions = API("sessions")
    val SignedInDevices = API("signedInDevices")
    val Storage = API("storage")
    object System {
      val CPU = API("system.cpu")
      val Display = API("system.display")
      val Memory = API("system.memory")
      val Network = API("system.network")
      val Storage = API("system.storage")
    }
    val TabCapture = API("tabCapture")
    val Tabs = API("tabs")
    val TopSites = API("topSites")
    val TTS = API("tts")
    val TTSEngine = API("ttsEngine")
    val UnlimitedStorage = API("unlimitedStorage")
    val VideoCapture = API("videoCapture")
    val VpnProvider = API("vpnProvider")
    val Wallpaper = API("wallpaper")
    val Webview = API("webview")
    val WebNavigation = API("webNavigation")
    val WebRequest = API("webRequest")
    val WebRequestBlocking = API("webRequestBlocking")
    val FileSystem = API("fileSystem")
    val HID = API("hid")
    val MDNS = API("mdns")
    val MediaGalleries = API("mediaGalleries")
    val PointerLock = API("pointerLock")
    val Serial = API("serial")
    val Socket = API("socket")
    val SyncFileSystem = API("syncFileSystem")
    val USB = API("usb")

    val All: Map[String, API] = Set(
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
}

