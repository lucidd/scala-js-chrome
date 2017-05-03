package chrome.pageAction.bindings

import chrome.events.bindings.Event
import chrome.pageAction.bindings.PageAction.ImageDataType
import chrome.tabs.bindings.Tab

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, ScalaJSDefined}
import scala.scalajs.js.|

@js.native
@JSGlobal("chrome.pageAction")
object PageAction extends js.Object {

  type ImageDataType = org.scalajs.dom.ImageData

  val onClicked: Event[js.Function1[Tab, _]] = js.native

  def show(tabId: Tab.Id): Unit = js.native

  def hide(tabId: Tab.Id): Unit = js.native

  def setTitle(details: SetTitleDetails): Unit = js.native

  def getTitle(
    details: GetTitleDetails,
    callback: js.Function1[String, _]): Unit =
    js.native

  def setIcon(
    details: SetIconDetails,
    callback: js.Function0[_]): Unit =
    js.native

  def setPopup(details: SetPopupDetails): Unit = js.native

  def getPopup(
    details: GetPopupDetails,
    callback: js.Function1[String, _]): Unit =
    js.native
}

@ScalaJSDefined
class GetPopupDetails(val tabId: Tab.Id) extends js.Object

object GetPopupDetails {

  def apply(tabId: Tab.Id): GetPopupDetails =
    new GetPopupDetails(tabId)
}

@ScalaJSDefined
class GetTitleDetails(val tabId: Tab.Id) extends js.Object

object GetTitleDetails {

  def apply(tabId: Tab.Id): GetTitleDetails =
    new GetTitleDetails(tabId)
}

@ScalaJSDefined
class SetIconDetails(
  val tabId: Tab.Id,
  val imageData: js.UndefOr[ImageDataType | js.Dictionary[ImageDataType]],
  val path: js.UndefOr[String | js.Dictionary[String]]
) extends js.Object

object SetIconDetails {

  def apply(
    tabId: Tab.Id,
    imageData: js.UndefOr[ImageDataType | js.Dictionary[ImageDataType]] = js.undefined,
    path: js.UndefOr[String | js.Dictionary[String]] = js.undefined
  ): SetIconDetails = new SetIconDetails(tabId, imageData, path)
}

@ScalaJSDefined
class SetPopupDetails(val tabId: Tab.Id, val popup: String) extends js.Object

object SetPopupDetails {

  def apply(tabId: Tab.Id, popup: String): SetPopupDetails =
    new SetPopupDetails(tabId, popup)
}

@ScalaJSDefined
class SetTitleDetails(val tabId: Tab.Id, val title: String) extends js.Object

object SetTitleDetails {

  def apply(tabId: Tab.Id, title: String): SetTitleDetails =
    new SetTitleDetails(tabId, title)
}

