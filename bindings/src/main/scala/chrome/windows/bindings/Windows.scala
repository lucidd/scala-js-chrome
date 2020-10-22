package chrome.windows.bindings

import chrome.events.bindings.Event
import chrome.tabs.bindings.Tab

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
trait GetOptions extends js.Object {
  val populate: js.UndefOr[Boolean] = js.native
}

object GetOptions {

  def apply(populate: js.UndefOr[Boolean] = js.undefined): GetOptions = {
    js.Dynamic
      .literal(
        populate = populate
      )
      .asInstanceOf[GetOptions]
  }
}

@js.native
trait CreateOptions extends js.Object {
  val url: js.UndefOr[js.Any] = js.native
  val tabId: js.UndefOr[Tab.Id] = js.native
  val left: js.UndefOr[Int] = js.native
  val top: js.UndefOr[Int] = js.native
  val width: js.UndefOr[Int] = js.native
  val height: js.UndefOr[Int] = js.native
  val focused: js.UndefOr[Boolean] = js.native
  val incognito: js.UndefOr[Boolean] = js.native
  val `type`: js.UndefOr[Window.CreateType] = js.native
  val state: js.UndefOr[Window.State] = js.native
}

object CreateOptions {

  def apply(
      url: js.Array[String] = js.Array(),
      tabId: js.UndefOr[Tab.Id] = js.undefined,
      left: js.UndefOr[Int] = js.undefined,
      top: js.UndefOr[Int] = js.undefined,
      width: js.UndefOr[Int] = js.undefined,
      height: js.UndefOr[Int] = js.undefined,
      focused: js.UndefOr[Boolean] = js.undefined,
      incognito: js.UndefOr[Boolean] = js.undefined,
      `type`: js.UndefOr[Window.CreateType] = js.undefined,
      state: js.UndefOr[Window.State] = js.undefined
  ): CreateOptions = {
    js.Dynamic
      .literal(
        url = url.length match {
          case 0 => js.undefined
          case 1 => url(0)
          case _ => url
        },
        tabId = tabId,
        left = left,
        top = top,
        width = width,
        height = height,
        focused = focused,
        incognito = incognito,
        `type` = `type`,
        state = state
      )
      .asInstanceOf[CreateOptions]
  }
}

@js.native
trait UpdateOptions extends js.Object {
  val left: js.UndefOr[Int] = js.native
  val top: js.UndefOr[Int] = js.native
  val width: js.UndefOr[Int] = js.native
  val height: js.UndefOr[Int] = js.native
  val focused: js.UndefOr[Boolean] = js.native
  val drawAttention: js.UndefOr[Boolean] = js.native
  val state: js.UndefOr[Window.State] = js.native
}

object UpdateOptions {

  def apply(
      left: js.UndefOr[Int] = js.undefined,
      top: js.UndefOr[Int] = js.undefined,
      width: js.UndefOr[Int] = js.undefined,
      height: js.UndefOr[Int] = js.undefined,
      focused: js.UndefOr[Boolean] = js.undefined,
      drawAttention: js.UndefOr[Boolean] = js.undefined,
      state: js.UndefOr[Window.State] = js.undefined
  ): UpdateOptions = {
    js.Dynamic
      .literal(
        left = left,
        top = top,
        width = width,
        height = height,
        focused = focused,
        drawAttention = drawAttention,
        state = state
      )
      .asInstanceOf[UpdateOptions]
  }
}

@js.native
@JSGlobal("chrome.windows")
object Windows extends js.Object {

  val WINDOW_ID_NONE: Window.Id = js.native
  val WINDOW_ID_CURRENT: Window.Id = js.native

  val onCreated: Event[js.Function1[Window, _]] = js.native
  val onRemoved: Event[js.Function1[Window.Id, _]] = js.native
  val onFocusChanged: Event[js.Function1[Window.Id, _]] = js.native

  def get(
      windowId: Window.Id,
      getInfo: js.UndefOr[GetOptions] = js.undefined,
      callback: js.Function1[Window, _]
  ): Unit = js.native

  def getCurrent(getInfo: js.UndefOr[GetOptions] = js.undefined, callback: js.Function1[Window, _]): Unit = js.native

  def getLastFocused(getInfo: js.UndefOr[GetOptions] = js.undefined, callback: js.Function1[Window, _]): Unit =
    js.native

  def getAll(getInfo: js.UndefOr[GetOptions] = js.undefined, callback: js.Function1[js.Array[Window], _]): Unit =
    js.native

  def create(
      createData: js.UndefOr[CreateOptions],
      callback: js.UndefOr[js.Function1[js.UndefOr[Window], _]] = js.undefined
  ): Unit = js.native

  def update(
      windowId: Window.Id,
      updateInfo: UpdateOptions,
      callback: js.UndefOr[js.Function1[Window, _]] = js.undefined
  ): Unit =
    js.native

  def remove(windowId: Window.Id, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit =
    js.native
}
