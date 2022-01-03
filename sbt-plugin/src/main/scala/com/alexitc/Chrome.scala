package com.alexitc

import chrome.Manifest
import sbt._

object Chrome {

  val manifestFileName = "manifest.json"

  def i18n(msg: String): String = s"__MSG_${msg}__"

  def icons(base: String, name: String, sizes: Set[Int]): Map[Int, String] = {
    sizes.map { size =>
      size -> s"$base/$size/$name"
    }.toMap
  }

  // TODO: I'm not sure if the jsDeps are actually useful but I'm keeping those just because
  // the original plugin had them, now that we use scalajs-bundler, it can be that we need
  // to re-work the source maps strategy for js dependencies
  def buildUnpackedDirectory(
      unpacked: File
  )(manifest: File, jsLib: File, jsDeps: Seq[File], resources: Seq[File]): File = {
    val libsAndDependencies =
      List(jsLib -> unpacked / jsLib.getName) ++ jsDeps.map(file => file -> unpacked / file.getName)

    val sourceMaps = (List(jsLib) ++ jsDeps)
      .map { sourceFile =>
        val fileName = sourceFile.getName + ".map"
        val originalSourceMap = sourceFile.getParentFile / fileName
        originalSourceMap -> unpacked / fileName
      }
      .filter(_._1.exists())

    val chromeSpecific = List(manifest -> unpacked / manifestFileName)

    IO.createDirectory(unpacked)

    resources.foreach { resource =>
      IO.copyDirectory(
        resource,
        unpacked,
        overwrite = true,
        preserveLastModified = true
      )
    }

    IO.copy(
      libsAndDependencies ::: sourceMaps ::: chromeSpecific,
      overwrite = true,
      preserveLastModified = true,
      preserveExecutable = true
    )

    unpacked
  }

  def generateManifest(out: File)(manifest: Manifest): File = {
    import JsonCodecs._
    import OptionPickler._

    // no spaces, drop null values
    val contentJson = writeJs(manifest).dropNullValues.getOrElse(ujson.Obj())
    val content = write(contentJson)
    IO.write(out, content)
    out
  }
}
