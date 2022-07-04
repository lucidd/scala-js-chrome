lazy val scalajsChromeV = sys.env.getOrElse("SCALAJS_CHROME_VERSION", "0.9.0+19-9a0b9098+20220703-1635-SNAPSHOT")

addSbtPlugin("com.alexitc" % "sbt-chrome-plugin" % scalajsChromeV)
