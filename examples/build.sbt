import chrome._
import chrome.permissions.APIPermission._
import chrome.permissions.{APIPermission, Permission}
import net.lullabyte.{Chrome, ChromeSbtPlugin}

lazy val examples = project.in(file(".")).aggregate(exampleApp, extension)

lazy val scalaJsChrome = ProjectRef(file("../."), "bindings")

lazy val exampleApp = project.in(file("app"))
  .dependsOn(scalaJsChrome)
  .enablePlugins(ChromeSbtPlugin)
  .settings(
    name := "Example App",
    version := "0.1.0",
    scalaVersion := "2.11.8",
    scalacOptions ++= Seq(
      "-language:implicitConversions",
      "-language:existentials",
      "-Xlint",
      "-deprecation",
      "-Xfatal-warnings",
      "-feature"
    ),
    persistLauncher := true,
    persistLauncher in Test := false,
    relativeSourceMaps := true,
    skip in packageJSDependencies := false,
    chromeManifest := new AppManifest {
      val name = Keys.name.value
      val version = Keys.version.value
      val app = App(
        background = Background(
          scripts = Chrome.defaultScripts
        )
      )
      override val defaultLocale = Some("en")
      override val icons = Chrome.icons(
        "icons",
        "app.png",
        Set(256)
      )
      override val permissions = Set[Permission](
        System.CPU,
        System.Display,
        System.Memory,
        System.Network,
        APIPermission.Storage
      )
    }
  )



lazy val extension = project.in(file("extension"))
  .dependsOn(scalaJsChrome)
  .enablePlugins(ChromeSbtPlugin)
  .settings(
    name := "Example Extension",
    version := "0.1.0",
    scalaVersion := "2.11.8",
    scalacOptions ++= Seq(
      "-language:implicitConversions",
      "-language:existentials",
      "-Xlint",
      "-deprecation",
      "-Xfatal-warnings",
      "-feature"
    ),
    persistLauncher := true,
    persistLauncher in Test := false,
    relativeSourceMaps := true,
    skip in packageJSDependencies := false,
    chromeManifest := new ExtensionManifest {
      val background = Background(
        scripts = Chrome.defaultScripts
      )
      val name = Keys.name.value
      val version = Keys.version.value
      override val icons = Chrome.icons(
        "icons",
        "app.png",
        Set(256)
      )
      override val permissions = Set[Permission](
        APIPermission.Tabs,
        APIPermission.Management
      )
    }
  )
