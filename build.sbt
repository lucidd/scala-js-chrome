import com.typesafe.sbt.SbtGit.GitKeys._

lazy val commonSettings = Seq(
  organization := "net.lullabyte",
  scalacOptions ++= Seq(
    "-Xlint",
    "-deprecation",
    "-Xfatal-warnings",
    "-feature"
  ), unmanagedSourceDirectories in Compile ++= Seq(
    baseDirectory.value.getParentFile / "shared" / "src" / "main" / "scala"
  ),
  scmInfo := Some(
    ScmInfo(
      url("http://github.com/lucidd/scala-js-chrome"),
      "scm:git@github.com:lucidd/scala-js-chrome.git"
    )
  ),
  developers := List(
    Developer(
      "lucidd",
      "Kevin Walter",
      "kevin.walter.private@gmail.com",
      url("http://lullabyte.net")
    )
  ),
  licenses += "MIT" -> url("http://www.opensource.org/licenses/mit-license.html"),
  homepage := Some(url("http://github.com/lucidd/scala-js-chrome")),
  useGpg := true,
  useGitDescribe := true
)

lazy val commonPlugins = Seq(GitVersioning)


lazy val bindings = project.in(file("bindings")).
  settings(commonSettings: _*).
  settings(
    name := "scala-js-chrome",
    scalaVersion := "2.11.8",
    crossScalaVersions := Seq("2.10.6", "2.11.8"),
    persistLauncher := false,
    persistLauncher in Test := false,
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.9.1"
    ),
    publishMavenStyle := true,
    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases"  at nexus + "service/local/staging/deploy/maven2")
    }
  ).
  enablePlugins(commonPlugins: _*).
  enablePlugins(ScalaJSPlugin)

lazy val plugin = project.in(file("sbt-plugin")).
  settings(commonSettings: _*).
  settings(
    sbtPlugin := true,
    name := "sbt-chrome-plugin",
    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core" % "0.4.1",
      "io.circe" %% "circe-generic" % "0.4.1",
      "io.circe" %% "circe-parser" % "0.4.1"
    ),
    publishMavenStyle := false,
    bintrayRepository := "sbt-plugins",
    bintrayOrganization := None,
    addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.11")
  ).
  enablePlugins(commonPlugins: _*)



lazy val monixInterop = project.in(file("interop/monix")).
  settings(commonSettings: _*).
  settings(
    name := "scala-js-chrome-monix",
    scalaVersion := "2.11.8",
    crossScalaVersions := Seq("2.10.6", "2.11.8"),
    persistLauncher := false,
    persistLauncher in Test := false,
    libraryDependencies ++= Seq(
      "io.monix" %%% "monix" % "2.1.2"
    ),
    publishMavenStyle := true,
    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases"  at nexus + "service/local/staging/deploy/maven2")
    }
  ).dependsOn(bindings)
   .enablePlugins(commonPlugins: _*)
   .enablePlugins(ScalaJSPlugin)

lazy val fs2Interop = project.in(file("interop/fs2")).
  settings(commonSettings: _*).
  settings(
    name := "scala-js-chrome-fs2",
    scalaVersion := "2.11.8",
    crossScalaVersions := Seq("2.11.8"),
    persistLauncher := false,
    persistLauncher in Test := false,
    libraryDependencies ++= Seq(
      "co.fs2" %%% "fs2-core" % "0.9.2"
    ),
    publishMavenStyle := true,
    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases"  at nexus + "service/local/staging/deploy/maven2")
    }
  ).dependsOn(bindings)
  .enablePlugins(commonPlugins: _*)
  .enablePlugins(ScalaJSPlugin)
