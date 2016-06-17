package chrome.contextMenus.bindings

import chrome.events.bindings.Event
import chrome.tabs.bindings.Tab

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}
import scala.scalajs.js.|

object MenuContexts {
  val ALL = "all"
  val PAGE = "page"
  val FRAME = "frame"
  val SELECTION = "selection"
  val LINKE = "link"
  val EDITABLE = "editable"
  val IMAGE = "image"
  val VIDEO = "video"
  val AUDIO = "audio"
  val LAUNCHER = "launcher"
  val BROWSER_ACTION = "browser_action"
  val PAGE_ACTION = "page_action"
}

object MenuType {
  val NORMAL = "normal"
  val CHECKBOX = "checkbox"
  val RADIO = "radio"
  val SEPARATOR = "separator"
}

@js.native
@JSName("chrome.contextMenus")
object ContextMenus extends js.Object{

  def create(createProperties: CreateProperties): String | Int = js.native

  def update(id: String | Int, properties: UpdateProperties): Unit = js.native

  def remove(menuItemId: String | Int, callback: js.Function0[Unit]): String | Int = js.native

  def removeAll(callback: js.Function0[Unit]): Unit = js.native

  val onClicked: Event[js.Function2[MenuInfo, Tab, _]] = js.native

}

@ScalaJSDefined
class UpdateProperties(
  val `type`: String = MenuType.NORMAL,
  val title: String,
  val checked: js.UndefOr[Boolean] = js.undefined,
  val contexts: js.UndefOr[js.Array[String]] = js.undefined,
  val onclick: js.UndefOr[js.Function2[MenuInfo, Tab, Unit]],
  val parentId: js.UndefOr[String | Int] = js.undefined,
  val documentUrlPatterns: js.UndefOr[js.Array[String]] = js.undefined,
  val targetUrlPatterns: js.UndefOr[js.Array[String]] = js.undefined,
  val enabled: Boolean = true
) extends js.Object

object CreateProperties {

  def apply(id: String, title: String, contexts: js.Array[String] = js.Array(MenuContexts.ALL)): CreateProperties =
    new CreateProperties(id = id, title = title , contexts = contexts)
}


@ScalaJSDefined
class CreateProperties(
  val `type`: String = MenuType.NORMAL,
  val id: String | Int,
  val title: String,
  val checked: js.UndefOr[Boolean] = js.undefined,
  val contexts: js.UndefOr[js.Array[String]] = js.undefined,
  val onclick: js.UndefOr[js.Function2[MenuInfo, Tab, Unit]] = js.undefined,
  val parentId: js.UndefOr[String | Int] = js.undefined,
  val documentUrlPatterns: js.UndefOr[js.Array[String]] = js.undefined,
  val targetUrlPatterns: js.UndefOr[js.Array[String]] = js.undefined,
  val enabled: Boolean = true
) extends js.Object

@js.native
trait  MenuInfo extends js.Object{
  val menuItemId: String | Int = js.native
  val parentMenuItemId: js.UndefOr[String | Int]
  val mediaType: js.UndefOr[String]
  val linkUrl: js.UndefOr[String]
  val srcUrl: js.UndefOr[String]
  val pageUrl: js.UndefOr[String]
  val frameUrl: js.UndefOr[String]
  val selectionText: js.UndefOr[String]
  val editable: Boolean
  val wasChecked: js.UndefOr[Boolean]
  val checked: js.UndefOr[Boolean]
}
