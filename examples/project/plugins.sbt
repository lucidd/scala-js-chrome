import sbt._
lazy val sbtPlugin = ProjectRef(file("../../."), "plugin")
lazy val root = project.in(file(".")).dependsOn(sbtPlugin)
