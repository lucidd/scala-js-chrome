import scala.scalajs.js
import scala.scalajs.js.JSApp

object Main extends JSApp {

  def main(): Unit = {
    if (!js.isUndefined(js.Dynamic.global.chrome.tabs)) {
      /* Running as background script */
      chrome.tabs.Tabs.onCreated.listen { tab =>
        println(s"Tab created: ${tab.url}")
      }
    }

    println("Hello World!")
  }

}
