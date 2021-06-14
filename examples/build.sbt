import chrome._
import chrome.permissions.Permission
import chrome.permissions.Permission.{API, Host}
import com.alexitc.{Chrome, ChromeSbtPlugin}

lazy val examples = project.in(file(".")).aggregate(exampleApp, extension)

lazy val scalaJsChrome = ProjectRef(file("../."), "bindings")

lazy val exampleApp = project
  .in(file("app"))
  .dependsOn(scalaJsChrome)
  .enablePlugins(ChromeSbtPlugin)
  .settings(
    name := "Example App",
    version := "0.1.0",
    scalaVersion := "2.13.6",
    scalacOptions ++= Seq(
      "-language:implicitConversions",
      "-language:existentials",
      "-Xlint",
      "-deprecation",
      "-Xfatal-warnings",
      "-feature"
    ),
    scalaJSUseMainModuleInitializer := true,
    Test / scalaJSUseMainModuleInitializer := false,
    scalaJSLinkerConfig := scalaJSLinkerConfig.value.withRelativizeSourceMapBase(
      Some((Compile / fastOptJS / artifactPath).value.toURI)
    ),
    packageJSDependencies / skip := false,
    // you can customize and have a static output name for lib and dependencies
    // instead of having the default files names like app-fastopt.js, ...
    (Compile / fastOptJS / artifactPath) := {
      (fastOptJS / crossTarget).value / "main.js"
    },
    (Compile / fullOptJS / artifactPath) := {
      (fullOptJS / crossTarget).value / "main.js"
    },
    (Compile / packageJSDependencies / artifactPath) := {
      (packageJSDependencies / crossTarget).value / "dependencies.js"
    },
    (Compile / packageMinifiedJSDependencies / artifactPath) := {
      (packageMinifiedJSDependencies / crossTarget).value / "dependencies.js"
    },
    chromeManifest := new AppManifest {
      val name = Keys.name.value
      val version = Keys.version.value

      val app = App(
        background = Background(
          scripts = List("main.js", "dependencies.js")
        )
      )
      override val defaultLocale = Some("en")

      override val icons = Chrome.icons(
        "icons",
        "app.png",
        Set(256)
      )

      override val permissions = Set[Permission](
        API.System.CPU,
        API.System.Display,
        API.System.Memory,
        API.System.Network,
        API.Storage
      )
    }
  )

lazy val extension = project
  .in(file("extension"))
  .dependsOn(scalaJsChrome)
  .enablePlugins(ChromeSbtPlugin)
  .settings(
    name := "Example Extension",
    version := "0.1.0",
    scalaVersion := "2.13.6",
    scalacOptions ++= Seq(
      "-language:implicitConversions",
      "-language:existentials",
      "-Xlint",
      "-deprecation",
      "-Xfatal-warnings",
      "-feature"
    ),
    scalaJSUseMainModuleInitializer := true,
    Test / scalaJSUseMainModuleInitializer := false,
    scalaJSLinkerConfig := scalaJSLinkerConfig.value.withRelativizeSourceMapBase(
      Some((Compile / fastOptJS / artifactPath).value.toURI)
    ),
    packageJSDependencies / skip := false,
    // you can customize and have a static output name for lib and dependencies
    // instead of having the default files names like extension-fastopt.js, ...
    (Compile / fastOptJS / artifactPath) := {
      (fastOptJS / crossTarget).value / "main.js"
    },
    (Compile / fullOptJS / artifactPath) := {
      (fullOptJS / crossTarget).value / "main.js"
    },
    (Compile / packageJSDependencies / artifactPath) := {
      (packageJSDependencies / crossTarget).value / "dependencies.js"
    },
    (Compile / packageMinifiedJSDependencies / artifactPath) := {
      (packageMinifiedJSDependencies / crossTarget).value / "dependencies.js"
    },
    chromeManifest := new ExtensionManifest {

      val background = Background(
        scripts = List("main.js", "dependencies.js")
      )
      val name = Keys.name.value
      val version = Keys.version.value

      override val icons = Chrome.icons(
        "icons",
        "app.png",
        Set(256)
      )

      override val permissions = Set[Permission](
        API.Tabs,
        API.Management,
        API.Storage
      )
    }
  )
