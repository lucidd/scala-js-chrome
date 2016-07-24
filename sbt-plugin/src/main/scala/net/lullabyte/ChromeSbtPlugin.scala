package net.lullabyte

import chrome.Manifest
import org.scalajs.sbtplugin.ScalaJSPlugin

import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys._
import sbt._

object ChromeSbtPlugin extends AutoPlugin {

  override def requires: Plugins = ScalaJSPlugin

  object autoImport {

    val chromeUnpackedOpt = TaskKey[File]("chromeUnpackedOpt")
    val chromeUnpackedFast = TaskKey[File]("chromeUnpackedFast")
    val chromePackage = TaskKey[File]("chromePackage")
    val chromeGenerateManifest = TaskKey[File]("chromeGenerateManifest")
    val chromeManifest = TaskKey[Manifest]("chromeManifest")


    lazy val baseSettings: Seq[Def.Setting[_]] = Seq(
      chromeUnpackedFast := {
        Chrome.buildUnpackedDirectory(target.value / "chrome" / "unpacked-fast")(
          (chromeGenerateManifest in Compile).value,
          (fastOptJS in Compile).value.data,
          (packageJSDependencies in Compile).value,
          (packageScalaJSLauncher in Compile).value.data,
          (resourceDirectories in Compile).value
        )
      },
      chromeUnpackedOpt := {
        Chrome.buildUnpackedDirectory(target.value / "chrome" / "unpacked-opt")(
          (chromeGenerateManifest in Compile).value,
          (fullOptJS in Compile).value.data,
          (packageMinifiedJSDependencies in Compile).value,
          (packageScalaJSLauncher in Compile).value.data,
          (resourceDirectories in Compile).value
        )
      },
      chromePackage := {
        val out = target.value / "chrome"
        val chromeAppDir = chromeUnpackedOpt.value
        val zipFile = new File(out, s"${name.value}.zip")
        IO.zip(allSubpaths(chromeAppDir), zipFile)
        zipFile
      },
      chromeGenerateManifest := {
        Chrome.generateManifest(target.value / "chrome" / "generated_manifest.json")(
          (chromeManifest in Compile).value
        )
      }
    )

  }


  import autoImport._

  override val projectSettings = baseSettings

}
