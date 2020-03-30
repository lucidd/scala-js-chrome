package com.alexitc

import chrome.Manifest
import org.scalajs.jsdependencies.sbtplugin.JSDependenciesPlugin
import org.scalajs.jsdependencies.sbtplugin.JSDependenciesPlugin.autoImport._
import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys._
import sbt._

object ChromeSbtPlugin extends AutoPlugin {

  override def requires: Plugins = ScalaJSPlugin && JSDependenciesPlugin

  object autoImport {

    val chromeUnpackedOpt = TaskKey[File]("chromeUnpackedOpt")
    val chromeUnpackedFast = TaskKey[File]("chromeUnpackedFast")
    val chromePackage = TaskKey[File]("chromePackage")
    val chromeGenerateManifest = TaskKey[File]("chromeGenerateManifest")
    val chromeManifest = TaskKey[Manifest]("chromeManifest")
    val fullOptJsLib = TaskKey[Attributed[File]]("fullOptJsLib")
    val fastOptJsLib = TaskKey[Attributed[File]]("fastOptJsLib")

    private val chromeDir = "chrome"

    lazy val baseSettings: Seq[Def.Setting[_]] = Seq(
      fastOptJsLib := (fastOptJS in Compile).value,
      chromeUnpackedFast := {
        Chrome.buildUnpackedDirectory(target.value / chromeDir / "unpacked-fast")(
          (chromeGenerateManifest in Compile).value,
          fastOptJsLib.value.data,
          (packageJSDependencies in Compile).value,
          (resourceDirectories in Compile).value
        )
      },
      fullOptJsLib := (fullOptJS in Compile).value,
      chromeUnpackedOpt := {
        Chrome.buildUnpackedDirectory(target.value / chromeDir / "unpacked-opt")(
          (chromeGenerateManifest in Compile).value,
          fullOptJsLib.value.data,
          (packageMinifiedJSDependencies in Compile).value,
          (resourceDirectories in Compile).value
        )
      },
      chromePackage := {
        val out = target.value / chromeDir
        val chromeAppDir = chromeUnpackedOpt.value
        val zipFile = new File(out, s"${name.value}.zip")
        val excludeFileNames = Set(
          ".DS_Store"
        )
        val fileFilter = AllPassFilter - new SimpleFilter(excludeFileNames.contains)
        IO.zip(Path.selectSubpaths(chromeAppDir, fileFilter), zipFile)
        zipFile
      },
      chromeGenerateManifest := {
        Chrome.generateManifest(target.value / chromeDir / "generated_manifest.json")(
          (chromeManifest in Compile).value
        )
      }
    )

  }


  import autoImport._

  override val projectSettings = baseSettings

}
