lazy val commonSettings = Seq(
  organization := "net.lullabyte",
  scalacOptions ++= Seq(
    "-Xlint",
    "-deprecation",
    "-Xfatal-warnings",
    "-feature"
  ),
  unmanagedSourceDirectories in Compile ++= Seq(
    baseDirectory.value.getParentFile / "shared" / "src" / "main" / "scala"
  )
)

lazy val bindings = project.in(file("bindings")).
  settings(commonSettings: _*).
  settings(
    name := "scala-js-chrome",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.11.6",
    persistLauncher := false,
    persistLauncher in Test := false,
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.8.0" withSources() withJavadoc()
    )
  ).
  enablePlugins(ScalaJSPlugin)

lazy val plugin = project.in(file("sbt-plugin")).
  settings(commonSettings: _*).
  settings(
    sbtPlugin := true,
    name := "sbt-chrome-plugin",
    version := "0.0.1-SNAPSHOT",
    addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.3")
  )

