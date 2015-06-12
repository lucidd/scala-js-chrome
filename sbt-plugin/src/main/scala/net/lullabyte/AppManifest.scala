package net.lullabyte

import chrome.permissions._

sealed trait Manifest {
  val name: String
  val version: String
  val defaultLocale: Option[String]
  val description: Option[String]
  val permissions: Set[Permission]
  val icons: Map[Int, String]
}

case class AppManifest(app: AppManifest.App,
                    manifestVersion: Int = 2,
                    name: String,
                    shortName: Option[String] = None,
                    version: String,
                    defaultLocale: Option[String] = None,
                    description: Option[String] = None,
                    offlineEnabled: Boolean = true,
                    icons: Map[Int, String] = Map(),
                    permissions: Set[Permission] = Set()) extends Manifest

object AppManifest {

  import upickle._

  case class Background(scripts: List[String])

  case class App(background: Background)

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
