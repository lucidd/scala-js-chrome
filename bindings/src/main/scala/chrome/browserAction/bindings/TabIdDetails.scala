package chrome.browserAction.bindings

import scala.scalajs.js

@js.native
trait TabIdDetails extends js.Object {
  val tabId: js.UndefOr[Int] = js.native
}

object TabIdDetails {

  def apply(tabId: js.UndefOr[Int] = js.undefined): TabIdDetails = {
    js.Dynamic
      .literal(
        tabId = tabId
      )
      .asInstanceOf[TabIdDetails]
  }
}
