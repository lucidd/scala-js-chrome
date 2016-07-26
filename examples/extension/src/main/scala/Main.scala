import scala.scalajs.js.JSApp

object Main extends JSApp {

  def main(): Unit = {
    chrome.tabs.Tabs.onCreated.listen { tab =>
      println(s"Tab created: ${tab.url}")
    }
    println("Hello World!")
  }

}
