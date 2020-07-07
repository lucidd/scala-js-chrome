package com.alexitc

import chrome.permissions.Permission.{API, Host}
import chrome.{AppManifest, ExtensionManifest, Manifest}

object JsonCodecs {

  import OptionPickler._

  implicit class JsonExt(val json: ujson.Value) extends AnyVal {

    def dropNullValues: Option[ujson.Value] = {
      json match {
        case ujson.Null => None
        case obj: ujson.Obj =>
          val newValues = obj.value.toList.flatMap {
            case (key, value) =>
              value.dropNullValues.map(key -> _)
          }
          if (newValues.isEmpty) None
          else Some(ujson.Obj.from(newValues))

        case arr: ujson.Arr =>
          val newValues = arr.value.toList.flatMap { value =>
            value.dropNullValues
          }
          if (newValues.isEmpty) None
          else Some(ujson.Arr.from(newValues))

        case x => Some(x)
      }
    }
  }

  private def omitIfEmpty[T](
      seq: Iterable[T]
  )(encode: T => ujson.Value): ujson.Value = {
    if (seq.isEmpty) ujson.Null
    else ujson.Arr.from(seq.map(encode))
  }

  private def omitIfEmpty[T](
      seq: Option[Iterable[T]]
  )(encode: T => ujson.Value): ujson.Value = {
    seq.map(s => omitIfEmpty(s)(encode)).getOrElse(ujson.Null)
  }

  implicit val socketEncoder: Writer[chrome.Sockets] = {
    writer[ujson.Value].comap { sockets =>
      val udp = ujson
        .Obj(
          "bind" -> omitIfEmpty(sockets.udp.map(_.bind))(ujson.Str.apply),
          "send" -> omitIfEmpty(sockets.udp.map(_.send))(ujson.Str.apply),
          "multicastMembership" ->
            omitIfEmpty(sockets.udp.map(_.multicastMembership))(ujson.Str.apply)
        )

      val tcp = ujson.Obj(
        "connect" -> omitIfEmpty(sockets.tcp.map(_.connect))(ujson.Str.apply)
      )

      val tcpServer = ujson.Obj(
        "listen" -> omitIfEmpty(sockets.tcp.map(_.listen))(ujson.Str.apply)
      )
      ujson.Obj("udp" -> udp, "tcp" -> tcp, "tcpServer" -> tcpServer)
    }
  }

  implicit val backgroundEncoder: Writer[chrome.Background] = {
    writer[ujson.Value].comap { background =>
      ujson.Obj("scripts" -> background.scripts.map(ujson.Str.apply))
    }
  }

  implicit val omniboxEncoder = writer[ujson.Value].comap[chrome.Omnibox] { omnibox =>
    ujson.Obj(("keyword", ujson.Str.apply(omnibox.keyword)))
  }

  implicit val externallyConnectableEncoder =
    writer[ujson.Value].comap[chrome.ExternallyConnectable] { ec =>
      ujson.Obj(
        ("keyword", writeJs(ec.acceptsTlsChannelId)),
        ("ids", omitIfEmpty(ec.ids)(ujson.Str.apply)),
        ("matches", omitIfEmpty(ec.ids)(ujson.Str.apply))
      )
    }

  implicit val storageEncoder = writer[ujson.Value].comap[chrome.Storage] { storage =>
    ujson.Obj(("managed_schema", ujson.Str.apply(storage.managedSchema)))
  }

  implicit val platformEncoder = writer[ujson.Value].comap[chrome.Platform] { platform =>
    ujson.Obj(
      ("nacl_arch", ujson.Str.apply(platform.naclArch)),
      ("sub_package_path", ujson.Str.apply(platform.subPackagePath))
    )
  }

  implicit val bluetoothEncoder = writer[ujson.Value].comap[chrome.Bluetooth] { bluetooth =>
    ujson.Obj(
      ("uuids", ujson.Arr.from(bluetooth.uuids.map(ujson.Str.apply))),
      ("socket", writeJs(bluetooth.socket)),
      ("low_energy", writeJs(bluetooth.lowEnergy)),
      ("peripheral", writeJs(bluetooth.peripheral))
    )
  }

  implicit val suggestedKeyEncoderr =
    writer[ujson.Value].comap[chrome.Commands.SuggestedKey] { key =>
      ujson.Obj(
        ("chromeos", writeJs(key.chromeos)),
        ("linux", writeJs(key.linux)),
        ("windows", writeJs(key.windows)),
        ("mac", writeJs(key.mac)),
        ("default", writeJs(key.default))
      )
    }

  implicit val browserActionEncoder =
    writer[ujson.Value].comap[chrome.BrowserAction] { browserAction =>
      ujson.Obj(
        ("default_title", writeJs(browserAction.title)),
        ("default_popup", writeJs(browserAction.popup)),
        ("default_icon", ujson.Obj.from(browserAction.icon.map {
          case (k, v) => (k.toString, ujson.Str.apply(v))
        }))
      )
    }

  implicit val pageActionEncoder =
    writer[ujson.Value].comap[chrome.PageAction] { pageAction =>
      ujson.Obj(
        ("default_title", writeJs(pageAction.title)),
        ("default_popup", writeJs(pageAction.popup)),
        ("default_icon", ujson.Obj.from(pageAction.icon.map {
          case (k, v) => (k.toString, ujson.Str.apply(v))
        }))
      )
    }

  implicit val optionUIEncoder = writer[ujson.Value].comap[chrome.OptionsUI] { optionUI =>
    ujson.Obj(
      ("page", ujson.Str.apply(optionUI.page)),
      ("chrome_style", writeJs(optionUI.chromeStyle))
    )
  }

  implicit val oauth2SettingsEncoder =
    writer[ujson.Value].comap[chrome.Oauth2Settings] { oauth2Settings =>
      ujson.Obj(
        ("client_id", writeJs(oauth2Settings.clientId)),
        ("scopes", writeJs(oauth2Settings.scopes))
      )
    }

  implicit val bookmarksUIEncoder =
    writer[ujson.Value].comap[chrome.BookmarksUI] { bookmarksUI =>
      ujson.Obj(
        ("remove_button", writeJs(bookmarksUI.removeButton)),
        (
          "remove_bookmark_shortcut",
          writeJs(bookmarksUI.removeBookmarkShortcut)
        )
      )
    }

  implicit val chromeUIOverridesEncoder =
    writer[ujson.Value].comap[chrome.ChromeUIOverrides] { chromeUIOverrides =>
      ujson.Obj(
        ("newtab", ujson.Str.apply(chromeUIOverrides.newtab)),
        ("bookmarks_ui", writeJs(chromeUIOverrides.bookmarksUI))
      )
    }

  implicit val chromeUrlOverridesEncoder = writer[ujson.Value].comap[chrome.ChromeUrlOverrides] { chromeUrlOverrides =>
    ujson.Obj(
      ("newtab", writeJs(chromeUrlOverrides.newtab)),
      ("bookmarks", writeJs(chromeUrlOverrides.bookmarks)),
      ("history", writeJs(chromeUrlOverrides.history))
    )
  }

  implicit val contentScriptEncoder = {
    writer[ujson.Value].comap[chrome.ContentScript] { contentScript =>
      ujson.Obj(
        ("matches", ujson.Arr.from(contentScript.matches.map(ujson.Str.apply))),
        ("css", ujson.Arr.from(contentScript.css.map(ujson.Str.apply))),
        ("js", ujson.Arr.from(contentScript.js.map(ujson.Str.apply))),
        ("run_at", writeJs(contentScript.run_at.map(_.name)))
      )
    }
  }

  implicit val actionEncoder =
    writer[ujson.Value].comap[chrome.Commands.Action] { action =>
      ujson.Obj(
        ("suggested_key", writeJs(action.suggestedKey)),
        ("description", writeJs(action.description)),
        ("global", writeJs(action.global))
      )
    }

  implicit val commandsEncoder = writer[ujson.Value].comap[chrome.Commands] { commands =>
    ujson.Obj.from(commands.actions.mapValues(x => writeJs(x)))
  }

  implicit val appEncoder = writer[ujson.Value].comap[chrome.App] { app =>
    ujson.Obj(("background", writeJs(app.background)))
  }

  def manifest2json(manifest: Manifest): Seq[(String, ujson.Value)] = {
    Seq(
      ("manifest_version", ujson.Num(manifest.manifestVersion)),
      ("name", ujson.Str.apply(manifest.name)),
      ("version", ujson.Str.apply(manifest.version)),
      ("default_locale", writeJs(manifest.defaultLocale)),
      ("description", writeJs(manifest.description)),
      ("icons", ujson.Obj.from(manifest.icons.map {
        case (k, v) => (k.toString, ujson.Str.apply(v))
      })),
      ("author", writeJs(manifest.author)),
      ("commands", writeJs(manifest.commands)),
      ("key", writeJs(manifest.key)),
      ("offline_enabled", writeJs(manifest.offlineEnabled)),
      ("version_name", writeJs(manifest.versionName)),
      ("update_url", writeJs(manifest.updateUrl)),
      ("short_name", writeJs(manifest.shortName)),
      ("minimum_chrome_version", writeJs(manifest.minimumChromeVersion)),
      ("storage", writeJs(manifest.storage)),
      (
        "platforms",
        if (manifest.platforms.isEmpty) ujson.Null
        else ujson.Arr.from(manifest.platforms.map(x => writeJs(x)))
      ),
      ("oauth2", writeJs(manifest.oauth2)),
      (
        "web_accessible_resources",
        if (manifest.webAccessibleResources.isEmpty) ujson.Null
        else writeJs(manifest.webAccessibleResources)
      ),
      ("permissions", omitIfEmpty(manifest.permissions) {
        case API(name) => ujson.Str.apply(name)
        case Host(url) => ujson.Str.apply(url)
      }),
      ("optional_permissions", omitIfEmpty(manifest.optionalPermissions) {
        case API(name) => ujson.Str.apply(name)
        case Host(url) => ujson.Str.apply(url)
      }),
      ("content_security_policy", writeJs(manifest.contentSecurityPolicy))
    )
  }

  implicit val extManifestEncoder = {
    writer[ujson.Value].comap[chrome.ExtensionManifest] { manifest =>
      val commonValues = manifest2json(manifest)
      val extValues = Seq(
        ("background", writeJs(manifest.background)),
        ("omnibox", writeJs(manifest.omnibox)),
        ("options_ui", writeJs(manifest.optionsUI)),
        ("browser_action", writeJs(manifest.browserAction)),
        ("page_action", writeJs(manifest.pageAction)),
        ("chrome_ui_overrides", writeJs(manifest.chromeUIOverrides)),
        ("chrome_url_overrides", writeJs(manifest.chromeUrlOverrides)),
        ("content_scripts", writeJs(manifest.contentScripts))
      )
      ujson.Obj.from(commonValues ++ extValues)
    }
  }

  implicit val appManifestEncoder = {
    writer[ujson.Value].comap[chrome.AppManifest] { manifest =>
      val commonValues = manifest2json(manifest)
      val appValues = Seq(
        ("app", writeJs(manifest.app)),
        ("bluetooth", writeJs(manifest.bluetooth)),
        ("kiosk_enabled", writeJs(manifest.kioskEnabled)),
        ("kiosk_only", writeJs(manifest.kioskOnly)),
        ("sockets", writeJs(manifest.sockets))
      )
      ujson.Obj.from(commonValues ++ appValues)
    }

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

  implicit val w: Writer[Manifest] = {
    writer[ujson.Value].comap[Manifest] {
      case am: AppManifest => writeJs(am)
      case em: ExtensionManifest => writeJs(em)
    }
  }
}
