package net.lullabyte

import chrome.permissions.Permission
import org.scalajs.sbtplugin.ScalaJSPlugin

import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys._
import sbt._

object ChromeSbtPlugin extends AutoPlugin {

  override def requires: Plugins = ScalaJSPlugin

  object autoImport {

    val chromePackageContent = SettingKey[File]("chromePackageContent",
      "The contents of this directory get copied to the into the chrome extension")
    val chromeBuildOpt = TaskKey[File]("chromeBuildOpt")
    val chromeBuildFast = TaskKey[File]("chromeBuildFast")
    val chromePackage = TaskKey[File]("chromePackage")

    val chromeGenerateManifest = TaskKey[File]("chromeGenerateManifest")
    val chromeName = SettingKey[String]("chromeName")
    val chromeDefaultLocale = SettingKey[Option[String]]("chromeDefaultLocale")
    val chromePermissions = SettingKey[Set[Permission]]("chromePermissions")
    val chromeIcons = SettingKey[Map[Int, String]]("chromeIcons")
    val chromeOfflineEnabled = SettingKey[Boolean]("chromeOfflineEnabled")

    lazy val baseSettings: Seq[Def.Setting[_]] = Seq(
      chromeName := name.value,
      chromeOfflineEnabled := true,
      chromeDefaultLocale := None,
      chromePermissions := Set(),
      chromePackageContent := file("content"),
      chromeIcons := Chrome.icons(
        "assets/icons",
        "app.png",
        Set(128)
      ),
      chromeBuildOpt := {
        Chrome.buildExtentionDirectory(target.value / "chrome" / "unpacked")(
          (chromeGenerateManifest in Compile).value,
          (fullOptJS in Compile).value.data,
          (packageJSDependencies in Compile).value,
          (packageScalaJSLauncher in Compile).value.data,
          (chromePackageContent in Compile).value
        )
      },
      chromePackage := {
        val out = target.value / "chrome"
        val chromeAppDir = chromeBuildOpt.value
        val zipFile = new File(out, s"${name.value}.zip")
        IO.zip(allSubpaths(chromeAppDir), zipFile)
        zipFile
      },
      chromeGenerateManifest := {
        Chrome.generateManifest(target.value / "chrome" / "generated_manifest.json")(
          (name in Compile).value,
          (version in Compile).value.replace("-SNAPSHOT", ""),
          (chromePermissions in Compile).value,
          (chromeDefaultLocale in Compile).value,
          (chromeOfflineEnabled in Compile).value,
          (chromeIcons in Compile).value
        )
      }
    )

  }


  import autoImport._

  override val projectSettings = baseSettings

}
