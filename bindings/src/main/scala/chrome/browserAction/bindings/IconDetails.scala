package chrome.browserAction.bindings

import org.scalajs.dom.ImageData

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.|.{Evidence, UnionOps, undefOr2jsAny}

@js.native
trait IconDetails extends TabIdDetails {
  val imageData: js.UndefOr[ImageData | js.Dictionary[ImageData]] = js.native

  val path: js.UndefOr[String | js.Dictionary[String]] = js.native
}

object IconDetails {
  // implicitly summon evidence that our union types subclass js.Any
  implicit val imageEvidence: Evidence[ImageData | js.Dictionary[ImageData], js.Any] = implicitly
  implicit val pathEvidence: Evidence[String | js.Dictionary[String], js.Any] = implicitly

  def apply(
      imageData: js.UndefOr[ImageData | js.Dictionary[ImageData]] = js.undefined,
      path: js.UndefOr[String | js.Dictionary[String]] = js.undefined,
      tabId: js.UndefOr[Int] = js.undefined
  ): IconDetails = {
    // explicitly merge our union types so that dynamic is happy
    val anyImageData: js.UndefOr[js.Any] = imageData.map(_.merge)
    val anyPath: js.UndefOr[js.Any] = path.map(_.asInstanceOf[js.Any])

    if (anyImageData.isDefined) {
      js.Dynamic
        .literal(
          imageData = anyImageData,
          tabId = tabId
        )
        .asInstanceOf[IconDetails]
    } else {
      js.Dynamic
        .literal(
          path = anyPath,
          tabId = tabId
        )
        .asInstanceOf[IconDetails]
    }
  }
}
