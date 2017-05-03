package chrome.browserAction.bindings

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.|.Evidence

@js.native
trait BadgeBackgroundColorDetails extends TabIdDetails {
  val color: String | js.Array[Int] = js.native
}

object BadgeBackgroundColorDetails {
  // implicitly summon evidence that our union type subclasses js.Any
  implicit val colorEvidence: Evidence[String | js.Array[Int], js.Any] = implicitly

  def apply(color: String | js.Array[Int], tabId: js.UndefOr[Int] = js.undefined): BadgeBackgroundColorDetails = {
    js.Dynamic
      .literal(
        color = color.merge[js.Any],
        tabId = tabId
      )
      .asInstanceOf[BadgeBackgroundColorDetails]
  }
}

