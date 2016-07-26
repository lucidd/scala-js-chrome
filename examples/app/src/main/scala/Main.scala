import chrome.app.runtime.bindings.LaunchData
import chrome.utils.ChromeApp

object Main extends ChromeApp {
  override def onLaunched(launchData: LaunchData): Unit = {
    println("Hello World!")
  }
}
