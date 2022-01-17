package chrome.browserAction.bindings

import scala.scalajs.js
import scala.scalajs.js.|.undefOr2jsAny

@js.native
trait TitleDetails extends TabIdDetails {
  val title: String = js.native
}

object TitleDetails {

  def apply(title: String, tabId: js.UndefOr[Int] = js.undefined): TitleDetails = {
    js.Dynamic
      .literal(
        title = title,
        tabId = tabId
      )
      .asInstanceOf[TitleDetails]
  }
}
