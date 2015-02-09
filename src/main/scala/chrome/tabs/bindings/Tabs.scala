package chrome.tabs.bindings


import chrome.events.bindings.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import chrome.runtime.bindings.Port
import chrome.windows.bindings.Window

@JSName("chrome.tabs")
object Tabs extends js.Object {

  def get(tabId: Tab.Id, callback: js.Function1[Tab, _]): Unit = js.native
  def getCurrent(callback: js.Function1[Tab, _]): Unit = js.native
  def connect(tabId: Tab.Id, connectInfo: js.UndefOr[ConnectInfo] = js.undefined): Port = js.native

  def sendRequest(tabId: Tab.Id, request: js.Any, responseCallback: js.UndefOr[js.Function1[js.Any, _]] = js.undefined): Unit = js.native
  def sendMessage(tabId: Tab.Id, message: js.Any, options: js.UndefOr[MessageOptions] = js.undefined, responseCallback: js.UndefOr[js.Function1[js.Any, _]] = js.undefined): Unit = js.native

  def create(createProperties: TabCreateProperties, callback: js.UndefOr[js.Function1[Tab, _]] = js.undefined): Unit = js.native
  def duplicate(tabId: Tab.Id, callback: js.UndefOr[js.Function1[js.UndefOr[Tab], _]] = js.undefined): Unit = js.native
  def query(queryInfo: TabQuery, callback: js.Function1[js.Array[Tab], _]): Unit = js.native
  
  def highlight(highlightInfo: HighlightInfo, callback: js.Function1[Window, _]): Unit = js.native
  
  def update(tabId: js.UndefOr[Tab.Id] = js.undefined, updateProperties: UpdateProperties, callback: js.UndefOr[js.Function1[js.UndefOr[Tab], _]] = js.undefined): Unit = js.native
  def move(tabIds: js.Any, moveProperties: MoveProperties, callback: js.UndefOr[js.Function1[js.Any, _]] = js.undefined): Unit = js.native
  
  def reload(tabId: js.UndefOr[Tab.Id] = js.undefined, reloadProperties: ReloadProperties, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native
  def remove(tabIds: js.Any, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native
  
  def detectLanguage(tabId: js.UndefOr[Tab.Id] = js.undefined, callback: js.Function1[String, _]): Unit = js.native
  def captureVisibleTab(windowId: js.UndefOr[Window.Id] = js.undefined, options: js.UndefOr[CaptureOptions] = js.undefined, callback: js.UndefOr[js.Function1[String, _]] = js.undefined): Unit = js.native
  
  def executeScript(tabId: js.UndefOr[Tab.Id] = js.undefined, details: CodeInjectionOptions, callback: js.UndefOr[js.Function1[js.UndefOr[js.Array[js.Any]], _]] = js.undefined): Unit = js.native
  def insertCSS(tabId: js.UndefOr[Tab.Id] = js.undefined, details: CodeInjectionOptions, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native
  
  def setZoom(tabId: js.UndefOr[Tab.Id] = js.undefined, zoomFactor: Double, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native
  def getZoom(tabId: js.UndefOr[Tab.Id] = js.undefined, callback: js.Function1[Double, _]): Unit = js.native
  
  def setZoomSettings(tabId: js.UndefOr[Tab.Id] = js.undefined, zoomSettings: ZoomSettings, callback: js.Function0[_]): Unit = js.native
  def getZoomSettings(tabId: js.UndefOr[Tab.Id] = js.undefined, callback: js.Function1[ZoomSettings, _]): Unit = js.native
  
  val onCreated: Event[js.Function1[Tab, _]] = js.native
  val onUpdated: Event[js.Function3[Tab.Id, ChangeInfo, Tab, _]] = js.native
  val onMoved: Event[js.Function2[Tab.Id, MoveInfo, _]] = js.native
  val onActivated: Event[js.Function1[ActiveInfo, _]] = js.native
  val onHighlighted: Event[js.Function1[HighlightInfo, _]] = js.native
  val onDetached: Event[js.Function2[Tab.Id, DetachInfo, _]] = js.native
  val onAttached: Event[js.Function2[Tab.Id, AttachInfo, _]] = js.native
  val onRemoved: Event[js.Function2[Tab.Id, RemoveInfo, _]] = js.native
  val onReplaced: Event[js.Function2[Tab.Id, Tab.Id, _]] = js.native
  val onZoomChange: Event[js.Function1[ZoomChangeInfo, _]] = js.native
  
}













































