inThisBuild(
  List(
    organization := "com.alexitc",
    homepage := Some(url("https://github.com/AlexITC/scala-js-chrome")),
    licenses := List("MIT" -> url("http://www.opensource.org/licenses/mit-license.html")),
    developers := List(
      Developer(
        "AlexITC",
        "Alexis Hernandez",
        "alexis22229@gmail.com",
        url("https://wiringbits.net")
      )
    )
  )
)

ThisBuild / versionScheme := Some("early-semver")

publish / skip := true

lazy val commonSettings = Seq(
  scalacOptions ++= {
    Seq(
      "-encoding",
      "UTF-8",
      "-feature",
      "-language:implicitConversions"
//      "-Xfatal-warnings"
    ) ++
      (CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((3, _)) =>
          Seq(
            "-unchecked",
            "-source:3.0-migration"
          )
        case _ =>
          Seq(
            "-Xlint",
            "-deprecation"
          )
      })
  },
  Compile / unmanagedSourceDirectories ++= Seq(
    baseDirectory.value.getParentFile / "shared" / "src" / "main" / "scala"
  )
)

lazy val commonPlugins = Seq()

lazy val bindings = project
  .in(file("bindings"))
  .settings(commonSettings: _*)
  .settings(
    name := "scala-js-chrome",
    scalaVersion := "3.1.0",
    crossScalaVersions ++= Seq("2.12.15", "2.13.8", "3.1.0"),
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "2.1.0"
    ),
    scalaJSUseMainModuleInitializer := true
  )
  .enablePlugins(commonPlugins: _*)
  .enablePlugins(ScalaJSPlugin)
  .enablePlugins(ScalaJSBundlerPlugin)

lazy val plugin = project
  .in(file("sbt-plugin"))
  .settings(commonSettings: _*)
  .settings(
    sbtPlugin := true,
    name := "sbt-chrome-plugin",
    libraryDependencies ++= {
      // NOTE: Avoid circe as it doesn't respect binary compatibility which causes lots of issues
      Seq(
        "com.lihaoyi" %%% "upickle" % "1.4.4",
        "org.scalactic" %% "scalactic" % "3.2.11" % "test",
        "org.scalatest" %% "scalatest" % "3.2.11" % "test"
      )
    },
    addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.8.0"),
    addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.20.0")
  )
  .enablePlugins(commonPlugins: _*)
