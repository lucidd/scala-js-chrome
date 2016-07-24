package chrome.tabs

import chrome.ChromeAPI
import chrome.events.EventSource
import chrome.events.EventSourceImplicits._
import chrome.permissions.APIPermission
import chrome.runtime.bindings.Port
import chrome.tabs.bindings._
import chrome.windows.bindings.Window
import chrome.utils.ErrorHandling._

import scala.concurrent.{Future, Promise}
import scala.scalajs.js
import scala.scalajs.js.UndefOr
import scala.scalajs.js.`|`

object Tabs extends ChromeAPI {

  val requiredPermissions: Set[APIPermission] = Set(APIPermission.Tabs)

  val onCreated: EventSource[Tab] = bindings.Tabs.onCreated
  val onUpdated: EventSource[(Tab.Id, ChangeInfo, Tab)] = bindings.Tabs.onUpdated
  val onMoved: EventSource[(Tab.Id, MoveInfo)] = bindings.Tabs.onMoved
  val onActivated: EventSource[ActiveInfo] = bindings.Tabs.onActivated
  val onHighlighted: EventSource[HighlightInfo] = bindings.Tabs.onHighlighted
  val onDetached: EventSource[(Tab.Id, DetachInfo)] = bindings.Tabs.onDetached
  val onAttached: EventSource[(Tab.Id, AttachInfo)] = bindings.Tabs.onAttached
  val onRemoved: EventSource[(Tab.Id, RemoveInfo)] = bindings.Tabs.onRemoved
  val onReplaced: EventSource[(Tab.Id, Tab.Id)] = bindings.Tabs.onReplaced
  val onZoomChange: EventSource[ZoomChangeInfo] = bindings.Tabs.onZoomChange

  def get(tabId: Tab.Id): Future[Tab] = {
    val promise = Promise[Tab]()
    bindings.Tabs.get(tabId, (tab: Tab) => {
      promise.complete(lastErrorOrValue(tab))
    })
    promise.future
  }

  def getCurrent: Future[Tab] = {
    val promise = Promise[Tab]()
    bindings.Tabs.getCurrent((tab: Tab) => {
      promise.complete(lastErrorOrValue(tab))
    })
    promise.future
  }

  def connect(tabId: Tab.Id,
              connectInfo: js.UndefOr[ConnectInfo] = js.undefined): Port = bindings.Tabs.connect(tabId, connectInfo)

  def sendRequest(tabId: Tab.Id, request: js.Any): Future[js.Any] = {
    val promise = Promise[js.Any]()
    bindings.Tabs.sendRequest(tabId, request, js.Any.fromFunction1((response: js.Any) => {
      promise.complete(lastErrorOrValue(response))
    }))
    promise.future
  }

  def sendMessage(tabId: Tab.Id, message: js.Any,
                  options: js.UndefOr[MessageOptions] = js.undefined): Future[js.Any] = {
    val promise = Promise[js.Any]()
    bindings.Tabs.sendMessage(tabId, message, options, js.Any.fromFunction1((response: js.Any) => {
      promise.complete(lastErrorOrValue(response))
    }))
    promise.future
  }

  def create(createProperties: TabCreateProperties): Future[Tab] = {
    val promise = Promise[Tab]()
    bindings.Tabs.create(createProperties, js.Any.fromFunction1((tab: Tab) => {
      promise.complete(lastErrorOrValue(tab))
    }))
    promise.future
  }

  def duplicate(tabId: Tab.Id): Future[UndefOr[Tab]] = {
    val promise = Promise[js.UndefOr[Tab]]()
    bindings.Tabs.duplicate(tabId, js.Any.fromFunction1((tab: js.UndefOr[Tab]) => {
      promise.complete(lastErrorOrValue(tab))
    }))
    promise.future
  }

  def query(queryInfo: TabQuery): Future[js.Array[Tab]] = {
    val promise = Promise[js.Array[Tab]]()
    bindings.Tabs.query(queryInfo, js.Any.fromFunction1((tabs: js.Array[Tab]) => {
      promise.complete(lastErrorOrValue(tabs))
    }))
    promise.future
  }

  def highlight(highlightInfo: HighlightInfo): Future[Window] = {
    val promise = Promise[Window]()
    bindings.Tabs.highlight(highlightInfo, js.Any.fromFunction1((window: Window) => {
      promise.complete(lastErrorOrValue(window))
    }))
    promise.future
  }

  def update(tabId: js.UndefOr[Tab.Id] = js.undefined, updateProperties: UpdateProperties): Future[js.UndefOr[Tab]] = {
    val promise = Promise[js.UndefOr[Tab]]()
    bindings.Tabs.update(tabId, updateProperties, js.Any.fromFunction1((tabs: js.UndefOr[Tab]) => {
      promise.complete(lastErrorOrValue(tabs))
    }))
    promise.future
  }

  def move(tabIds: js.Array[Tab.Id], moveProperties: MoveProperties): Future[js.Array[Tab]] = {
    val promise = Promise[js.Array[Tab]]()
    bindings.Tabs.move(tabIds, moveProperties, js.Any.fromFunction1((tabs: Tab | js.Array[Tab]) => {
      promise.complete(
        lastErrorOrValue{
          if(tabs.isInstanceOf[js.Array[_]]) tabs.asInstanceOf[js.Array[Tab]]
          else js.Array(tabs.asInstanceOf[Tab])
        }
      )
    }))
    promise.future
  }

  def reload(tabId: js.UndefOr[Tab.Id] = js.undefined, reloadProperties: ReloadProperties): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.Tabs.reload(tabId, reloadProperties, js.Any.fromFunction0(() => {
      promise.complete(lastErrorOrValue(()))
    }))
    promise.future
  }

  def remove(tabIds: js.Array[Tab.Id]): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.Tabs.remove(tabIds, js.Any.fromFunction0(() => {
      promise.complete(lastErrorOrValue(()))
    }))
    promise.future
  }

  def detectLanguage(tabId: js.UndefOr[Tab.Id] = js.undefined): Future[String] = {
    val promise = Promise[String]()
    bindings.Tabs.detectLanguage(tabId, js.Any.fromFunction1((language: String) => {
      promise.complete(lastErrorOrValue(language))
    }))
    promise.future
  }

  def captureVisibleTab(windowId: js.UndefOr[Window.Id] = js.undefined,
                        options: js.UndefOr[CaptureOptions] = js.undefined): Future[String] = {
    val promise = Promise[String]()
    bindings.Tabs.captureVisibleTab(windowId, options, js.Any.fromFunction1((dataUrl: String) => {
      promise.complete(lastErrorOrValue(dataUrl))
    }))
    promise.future
  }

  def executeScript(tabId: js.UndefOr[Tab.Id] = js.undefined,
                    details: CodeInjectionOptions): Future[js.UndefOr[js.Array[js.Any]]] = {
    val promise = Promise[js.UndefOr[js.Array[js.Any]]]()
    bindings.Tabs.executeScript(tabId, details, js.Any.fromFunction1((result: js.UndefOr[js.Array[js.Any]]) => {
      promise.complete(lastErrorOrValue(result))
    }))
    promise.future
  }

  def insertCSS(tabId: js.UndefOr[Tab.Id] = js.undefined, details: CodeInjectionOptions): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.Tabs.insertCSS(tabId, details, js.Any.fromFunction0(() => {
      promise.complete(lastErrorOrValue(()))
    }))
    promise.future
  }

  def setZoom(tabId: js.UndefOr[Tab.Id] = js.undefined, zoomFactor: Double): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.Tabs.setZoom(tabId, zoomFactor, js.Any.fromFunction0(() => {
      promise.complete(lastErrorOrValue(()))
    }))
    promise.future
  }

  def getZoom(tabId: js.UndefOr[Tab.Id] = js.undefined): Future[Double] = {
    val promise = Promise[Double]()
    bindings.Tabs.getZoom(tabId, js.Any.fromFunction1((zoomFactor: Double) => {
      promise.complete(lastErrorOrValue(zoomFactor))
    }))
    promise.future
  }

  def setZoomSettings(tabId: js.UndefOr[Tab.Id] = js.undefined, zoomSettings: ZoomSettings): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.Tabs.setZoomSettings(tabId, zoomSettings, js.Any.fromFunction0(() => {
      promise.complete(lastErrorOrValue(()))
    }))
    promise.future
  }

  def getZoomSettings(tabId: js.UndefOr[Tab.Id] = js.undefined): Future[ZoomSettings] = {
    val promise = Promise[ZoomSettings]()
    bindings.Tabs.getZoomSettings(tabId, js.Any.fromFunction1((zoomSettings: ZoomSettings) => {
      promise.complete(lastErrorOrValue(zoomSettings))
    }))
    promise.future
  }


}
