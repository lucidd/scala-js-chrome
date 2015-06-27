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
      url("http://github.com/lucidd/scala-js-chrome"), "scm:git@github.com:lucidd/scala-js-chrome.git"
    )
  ),
  developers := List(
    Developer("lucidd", "Kevin Walter", "kevin.walter.private@gmail.com", url("http://lullabyte.net"))
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
    scalaVersion := "2.11.6",
    persistLauncher := false,
    persistLauncher in Test := false,
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.8.1" withSources() withJavadoc()
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
      "com.lihaoyi" %% "upickle" % "0.2.8" withSources() withJavadoc()
    ),
    publishMavenStyle := false,
    bintrayRepository := "sbt-plugins",
    bintrayOrganization := None,
    addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.3")
  ).
  enablePlugins(commonPlugins: _*)

