package net.lullabyte

import chrome.{Manifest, ExtensionManifest, AppManifest}
import chrome.permissions.{APIPermission, HostPermission}


object Pickler {

  import upickle._

  def manifest2Seq(m: Manifest): Seq[(String, Js.Value)] = Seq(
    "name" -> Js.Str(m.name),
    "manifest_version" -> Js.Num(m.manifestVersion),
    "version" -> Js.Str(m.version),
    "icons" -> Js.Obj(m.icons.map {
      case (k, v) => k.toString -> Js.Str(v)
    }.toSeq: _*),
    "permissions" -> Js.Arr(m.permissions.map {
      case APIPermission(name, _) => Js.Str(name)
      case HostPermission(url) => Js.Str(url)
    }.toSeq: _*)
  ) ++
  m.defaultLocale.map(x => "default_locale" -> Js.Str(x)) ++
  m.shortName.map(x => "short_name" -> Js.Str(x)) ++
  m.description.map(x => "description" -> Js.Str(x)) ++
  m.shortName.map(x => "short_name" -> Js.Str(x)) ++
  m.minimumChromeVersion.map(x => "minimum_chrome_version" -> Js.Str(x))


  implicit val manifestWriter = upickle.Writer[Manifest] {
    case app: AppManifest => appManifestWriter.write(app)
    case extension: ExtensionManifest => extensionManifestWriter.write(extension)
  }

  implicit val extensionManifestWriter: Writer[ExtensionManifest] = upickle.Writer {
    case m => {
      val props = manifest2Seq(m) ++ Seq(
        "background" -> Js.Obj(
          "scripts" -> Js.Arr(m.background.scripts.map(Js.Str(_)): _*)
        )
      )

      Js.Obj(
        props: _*
      )
    }
  }

  implicit val appManifestWriter: Writer[AppManifest] = upickle.Writer {
    case m => {
      val props = manifest2Seq(m) ++ Seq(
        "app" -> Js.Obj(
          "background" -> Js.Obj(
            "scripts" -> Js.Arr(m.app.background.scripts.map(Js.Str(_)): _*)
          )
        )
      ) ++
      m.sockets.map { x => "sockets" -> Js.Obj(
        Seq() ++
        x.udp.map { udp => "udp" -> Js.Obj(
          "bind" -> Js.Arr(udp.bind.map(Js.Str).toSeq: _*),
          "send" -> Js.Arr(udp.send.map(Js.Str).toSeq: _*),
          "multicastMembership" -> Js.Arr(udp.multicastMembership.map(Js.Str).toSeq: _*)
        )} ++
        x.tcp.map { tcp =>
          "tcp" -> Js.Obj(
            "connect" -> Js.Arr(tcp.connect.map(Js.Str).toSeq: _*)
        )} ++
        x.tcp.map { tcp =>
          "tcpServer" -> Js.Obj(
            "listen" -> Js.Arr(tcp.listen.map(Js.Str).toSeq: _*)
        )}: _*
      )}

      Js.Obj(
        props: _*
      )
    }
  }
}

