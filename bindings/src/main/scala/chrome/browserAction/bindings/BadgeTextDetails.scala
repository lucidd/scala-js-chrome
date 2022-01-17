package chrome.browserAction.bindings

import scala.scalajs.js
import scala.scalajs.js.|.undefOr2jsAny

@js.native
trait BadgeTextDetails extends TabIdDetails {
  val text: String = js.native
}

object BadgeTextDetails {

  def apply(text: String, tabId: js.UndefOr[Int] = js.undefined): BadgeTextDetails = {
    js.Dynamic
      .literal(
        text = text,
        tabId = tabId
      )
      .asInstanceOf[BadgeTextDetails]
  }
}
