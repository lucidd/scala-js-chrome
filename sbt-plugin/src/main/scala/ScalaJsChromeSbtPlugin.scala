import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt._
import sbt.Keys._

object ScalaJsChromeSbtPlugin extends AutoPlugin {

  sealed trait ProjectType

  object Extension extends ProjectType

  object App extends ProjectType

  override def requires = ScalaJSPlugin

  object autoImports {

    val projectType = SettingKey[ProjectType]("projectType")
    val buildOptChrome = TaskKey[File]("buildChrome")
    val packageChrome = TaskKey[File]("packageChrome")

    lazy val baseSettings: Seq[Def.Setting[_]] = Seq(
      projectType := App,
      buildOptChrome := {
        val base = file(".")
        val jsFile = (fullOptJS in Compile).value.data
        val jsDeps = (packageJSDependencies in Compile).value
        val jsLauncher = (packageScalaJSLauncher in Compile).value.data
        val out = base / "out"
        IO.createDirectory(out)
        IO.copy(List(
          (jsFile, out / "main.js"),
          (jsDeps, out / "deps.js"),
          (jsLauncher, out / "launcher.js"),
          (base / "manifest.json", out / "manifest.json")
        ), overwrite = true, preserveLastModified = true)
        IO.copyDirectory(base / "assets", out / "assets")
        IO.move(out / "assets" / "_locales", out / "_locales")
        out
      },
      packageChrome := {
        val base = file(".")
        val chromeAppDir = buildOptChrome.value
        val zipFile = new File(base, s"${name.value}.zip")
        IO.zip(allSubpaths(chromeAppDir), zipFile)
        zipFile
      }
    )

  }

  import autoImports._

  override val projectSettings =
    inConfig(Compile)(baseSettings) ++
    inConfig(Test)(baseSettings)

}
