lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin)

name := "scala-js-chrome"

version := "0.0.1-SNAPSHOT"

organization := "net.lullabyte"

scalaVersion := "2.11.4"

persistLauncher := false

persistLauncher in Test := false


libraryDependencies ++= Seq(
  "org.scala-js" % "scalajs-dom_sjs0.6.0-M1_2.11" % "0.7.1-SNAPSHOT" withSources() withJavadoc()
)