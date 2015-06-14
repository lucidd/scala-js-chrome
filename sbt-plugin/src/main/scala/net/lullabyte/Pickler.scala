package net.lullabyte

import chrome.AppManifest
import chrome.permissions.{HostPermission, APIPermission}

object Pickler {

  import upickle._

  implicit val manifestWriter = upickle.Writer[AppManifest] {
    case m => {
      val props = Seq(
        "app" -> Js.Obj(
          "background" -> Js.Obj(
            "scripts" -> Js.Arr(m.app.background.scripts.map(Js.Str(_)): _*)
          )
        ),
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
        m.description.map(x => "description" -> Js.Str(x))

      Js.Obj(
        props: _*
      )
    }
  }
}

