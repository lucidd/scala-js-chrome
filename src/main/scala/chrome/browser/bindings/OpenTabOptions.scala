package chrome.browser.bindings

import scala.scalajs.js

class OpenTabOptions extends js.Object {
  val url: String = js.native
}

object OpenTabOptions {

  def apply(url: String): OpenTabOptions = {
    js.Dynamic.literal(
      url = url
    ).asInstanceOf[OpenTabOptions]
  }

}
