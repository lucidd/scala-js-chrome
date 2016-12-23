package net.lullabyte

import io.circe._
import io.circe.syntax._
import io.circe.generic.semiauto._
import chrome._
import chrome.Commands._
import chrome.permissions.Permission.{API, Host}

object JsonCodecs {

  private def omitIfEmpty[T](seq: Iterable[T])(encode: T => Json): Json =
    if (seq.isEmpty) Json.Null
    else Json.fromValues(seq.map(encode))

  implicit val socketEncoder = Encoder.instance[chrome.Sockets] { sockets =>
    Json.obj(
      ("udp", Json.obj(
        ("bind", sockets.udp.map(x => Json.fromValues(x.bind.map(Json.fromString))).asJson),
        ("send", sockets.udp.map(x => Json.fromValues(x.send.map(Json.fromString))).asJson),
        ("multicastMembership", sockets.udp.map(
          x => Json.fromValues(x.multicastMembership.map(Json.fromString))).asJson
        )
      )),
      ("tcp", Json.obj(
        ("connect", sockets.tcp.map(x => Json.fromValues(x.connect.map(Json.fromString))).asJson)
      )),
      ("tcpServer", Json.obj(
        ("listen", sockets.tcp.map(x => Json.fromValues(x.listen.map(Json.fromString))).asJson)
      ))
    )
  }

  implicit val backgroundEncoder = Encoder.instance[chrome.Background] { background =>
    Json.obj(
        ("scripts", Json.fromValues(
          background.scripts.map(Json.fromString)
        ))
      )
  }

  implicit val omniboxEncoder = Encoder.instance[chrome.Omnibox] { omnibox =>
    Json.obj(
      ("keyword", Json.fromString(omnibox.keyword))
    )
  }

  implicit val externallyConnectableEncoder = Encoder.instance[chrome.ExternallyConnectable] { ec =>
    Json.obj(
      ("keyword", ec.acceptsTlsChannelId.asJson),
      ("ids", omitIfEmpty(ec.ids)(Json.fromString)),
      ("matches", omitIfEmpty(ec.ids)(Json.fromString))
    )
  }

  implicit val storageEncoder = Encoder.instance[chrome.Storage] { storage =>
    Json.obj(
      ("managed_schema", Json.fromString(storage.managedSchema))
    )
  }

  implicit val platformEncoder = Encoder.instance[chrome.Platform] { platform =>
    Json.obj(
      ("nacl_arch", Json.fromString(platform.naclArch)),
      ("sub_package_path", Json.fromString(platform.subPackagePath))
    )
  }

  implicit val bluetoothEncoder = Encoder.instance[chrome.Bluetooth] { bluetooth =>
    Json.obj(
      ("uuids", Json.fromValues(bluetooth.uuids.map(Json.fromString))),
      ("socket", bluetooth.socket.asJson),
      ("low_energy", bluetooth.lowEnergy.asJson),
      ("peripheral", bluetooth.peripheral.asJson)
    )
  }


  implicit val suggestedKeyEncoderr = Encoder.instance[chrome.Commands.SuggestedKey] { key =>
    Json.obj(
      ("chromeos", key.chromeos.asJson),
      ("linux", key.linux.asJson),
      ("windows", key.windows.asJson),
      ("mac", key.mac.asJson),
      ("default", key.default.asJson)
    )
  }

  implicit val browserActionEncoder = Encoder.instance[chrome.BrowserAction] { browserAction =>
    Json.obj(
      ("default_title", browserAction.title.asJson),
      ("default_popup", browserAction.popup.asJson),
      ("default_icon", Json.fromFields(
        browserAction.icon.map {
          case (k, v) => (k.toString, Json.fromString(v))
        }
      ))
    )
  }

  implicit val optionUIEncoder = Encoder.instance[chrome.OptionsUI] { optionUI =>
    Json.obj(
      ("page", Json.fromString(optionUI.page)),
      ("chrome_style", optionUI.chromeStyle.asJson)
    )
  }

  implicit val bookmarksUIEncoder = Encoder.instance[chrome.BookmarksUI] { bookmarksUI =>
    Json.obj(
      ("remove_button", bookmarksUI.removeButton.asJson),
      ("remove_bookmark_shortcut", bookmarksUI.removeBookmarkShortcut.asJson)
    )
  }

  implicit val chromeUIOverridesEncoder = Encoder.instance[chrome.ChromeUIOverrides] { chromeUIOverrides =>
    Json.obj(
      ("newtab", Json.fromString(chromeUIOverrides.newtab)),
      ("bookmarks_ui", chromeUIOverrides.bookmarksUI.asJson)
    )
  }

  implicit val actionEncoder = Encoder.instance[chrome.Commands.Action] { action =>
    Json.obj(
      ("suggested_key", action.suggestedKey.asJson),
      ("description", action.description.asJson),
      ("global", action.global.asJson)
    )
  }

  implicit val commandsEncoder = Encoder.instance[chrome.Commands] { commands =>
    Json.fromFields(commands.actions.mapValues(_.asJson))
  }

  implicit val appEncoder = Encoder.instance[chrome.App] { app =>
    Json.obj(
      ("background", app.background.asJson)
    )
  }


  def manifest2json(manifest: Manifest): Seq[(String, Json)] = {
    Seq(
      ("manifest_version", Json.fromInt(manifest.manifestVersion)),
      ("name", Json.fromString(manifest.name)),
      ("version", Json.fromString(manifest.version)),
      ("default_locale", manifest.defaultLocale.asJson),
      ("description", manifest.description.asJson),
      ("icons", Json.fromFields(manifest.icons.map {
        case (k, v) => (k.toString, Json.fromString(v))
      })),
      ("author", manifest.author.asJson),
      ("commands", manifest.commands.asJson),
      ("key", manifest.key.asJson),
      ("offline_enabled", manifest.offlineEnabled.asJson),
      ("version_name", manifest.versionName.asJson),
      ("update_url", manifest.updateUrl.asJson),
      ("short_name", manifest.shortName.asJson),
      ("minimum_chrome_version", manifest.minimumChromeVersion.asJson),
      ("storage", manifest.storage.asJson),
      ("platforms", if(manifest.platforms.isEmpty) Json.Null else manifest.platforms.asJson),
      ("oauth2", manifest.oauth2.asJson),
      ("web_accessible_resources",
        if (manifest.webAccessibleResources.isEmpty) Json.Null else manifest.webAccessibleResources.asJson),
      ("permissions",
        omitIfEmpty(manifest.permissions) {
          case API(name) => Json.fromString(name)
          case Host(url) => Json.fromString(url)
        }
      ),
      ("optional_permissions",
        omitIfEmpty(manifest.optionalPermissions) {
          case API(name) => Json.fromString(name)
          case Host(url) => Json.fromString(url)
        }
      )
    )
  }

  implicit val extManifestEncoder = Encoder.instance[chrome.ExtensionManifest] { manifest =>
    val commonValues = manifest2json(manifest)
    val extValues = Seq(
      ("background", manifest.background.asJson),
      ("omnibox", manifest.omnibox.asJson),
      ("options_ui", manifest.optionsUI.asJson),
      ("browser_action", manifest.browserAction.asJson),
      ("chrome_ui_overrides", manifest.chromeUIOverrides.asJson)
    )
    Json.fromFields(
      commonValues ++ extValues
    )
  }


  implicit val appManifestEncoder = Encoder.instance[chrome.AppManifest] { manifest =>
    val commonValues = manifest2json(manifest)
    val appValues = Seq(
      ("app", appEncoder(manifest.app)),
      ("bluetooth", manifest.bluetooth.asJson),
      ("kiosk_enabled", manifest.kioskEnabled.asJson),
      ("kiosk_only", manifest.kioskOnly.asJson),
      ("sockets", manifest.sockets.asJson)
    )
    Json.fromFields(
      commonValues ++ appValues
    )


    // Required


    //// Optional
    //"copresence": ...,
    //"current_locale": ...,
    //"event_rules": [{...}],
    //"externally_connectable": {
    //  "matches": ["*://*.example.com/*"]
    //},
    //"file_handlers": {...},
    //"file_system_provider_capabilities": {
    //  "configurable": true,
    //  "multiple_mounts": true,
    //  "source": "network"
    //},
    //"import": [{"id": "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"}],
    //"nacl_modules": [...],
    //"requirements": {...},
    //"sandbox": [...],
    //"signature": ...,
    //"system_indicator": ...,
    //"url_handlers": {...},
    //"usb_printers": {
    //  "filters": [...]
    //},
    //"webview": {...}
  }

  implicit val manifestEncoder = Encoder.instance[Manifest] {
    case app: AppManifest => appManifestEncoder(app)
    case ext: ExtensionManifest => extManifestEncoder(ext)
  }


}
