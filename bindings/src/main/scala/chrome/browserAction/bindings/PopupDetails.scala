package chrome.browserAction.bindings

import scala.scalajs.js
import scala.scalajs.js.|.undefOr2jsAny

@js.native
trait PopupDetails extends TabIdDetails {
  val popup: String = js.native
}

object PopupDetails {

  def apply(popup: String, tabId: js.UndefOr[Int] = js.undefined): PopupDetails = {
    js.Dynamic
      .literal(
        popup = popup,
        tabId = tabId
      )
      .asInstanceOf[PopupDetails]
  }
}
