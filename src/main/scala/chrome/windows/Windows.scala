package chrome.windows

import bindings._
import chrome.events.EventSource
import chrome.events.EventSourceImplicits._

import scala.concurrent.{Promise, Future}
import scala.scalajs.js

object Windows {

  val WINDOW_ID_NONE: Window.Id = bindings.Windows.WINDOW_ID_NONE
  val WINDOW_ID_CURRENT: Window.Id = bindings.Windows.WINDOW_ID_CURRENT

  val onCreated: EventSource[Window] = bindings.Windows.onCreated
  val onRemoved: EventSource[Window.Id] = bindings.Windows.onRemoved
  val onFocusChanged: EventSource[Window.Id] = bindings.Windows.onFocusChanged

  def get(windowId: Window.Id, getInfo: js.UndefOr[GetOptions] = js.undefined): Future[Window] = {
    val promise = Promise[Window]()
    bindings.Windows.get(windowId, getInfo, (window: Window) => {
      promise.complete(chrome.lastErrorOrValue(window))
    })
    promise.future
  }

  def getCurrent(getInfo: js.UndefOr[GetOptions] = js.undefined): Future[Window] = {
    val promise = Promise[Window]()
    bindings.Windows.getCurrent(getInfo, (window: Window) => {
      promise.complete(chrome.lastErrorOrValue(window))
    })
    promise.future
  }

  def getLastFocused(getInfo: js.UndefOr[GetOptions] = js.undefined): Future[Window] = {
    val promise = Promise[Window]()
    bindings.Windows.getLastFocused(getInfo, (window: Window) => {
      promise.complete(chrome.lastErrorOrValue(window))
    })
    promise.future
  }

  def getAll(getInfo: js.UndefOr[GetOptions] = js.undefined): Future[List[Window]] = {
    val promise = Promise[List[Window]]()
    bindings.Windows.getAll(getInfo, (windows: js.Array[Window]) => {
      promise.complete(chrome.lastErrorOrValue(windows.toList))
    })
    promise.future
  }

  def create(createData: js.UndefOr[CreateOptions]): Future[Option[Window]] = {
    val promise = Promise[Option[Window]]()
    bindings.Windows.create(createData, js.Any.fromFunction1((window: js.UndefOr[Window]) => {
      promise.complete(chrome.lastErrorOrValue(window.toOption))
    }))
    promise.future
  }

  def update(windowId: Window.Id, updateInfo: UpdateOptions): Future[Window] = {
    val promise = Promise[Window]()
    bindings.Windows.update(windowId, updateInfo, js.Any.fromFunction1((window: Window) => {
      promise.complete(chrome.lastErrorOrValue(window))
    }))
    promise.future
  }

  def remove(windowId: Window.Id): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.Windows.remove(windowId, js.Any.fromFunction0(() => {
      promise.complete(chrome.lastErrorOrValue(()))
    }))
    promise.future
  }
}
