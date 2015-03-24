lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin)

name := "scala-js-chrome"

version := "0.0.1-SNAPSHOT"

organization := "net.lullabyte"

scalaVersion := "2.11.5"

persistLauncher := false

persistLauncher in Test := false

scalacOptions ++= Seq(
    "-Xlint",
    "-deprecation",
    "-Xfatal-warnings"
)

libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.8.0" withSources() withJavadoc()
)
