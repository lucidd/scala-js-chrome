package chrome.utils

import chrome.app.runtime.Runtime
import chrome.app.runtime.bindings.{LaunchData, Request}

trait ChromeApp {

  def main(args: Array[String]): Unit = {
    Runtime.onLaunched.listen(onLaunched)
    Runtime.onRestarted.listen((_) => onRestart)
    Runtime.onEmbedRequested.listen(onEmbedRequested)
  }

  def onLaunched(launchData: LaunchData): Unit = {}

  def onRestart(): Unit = {}

  def onEmbedRequested(request: Request): Unit = {}

}
