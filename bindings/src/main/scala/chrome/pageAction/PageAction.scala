package chrome.pageAction

import chrome.pageAction.bindings._
import chrome.events.EventSource
import chrome.events.EventSourceImplicits._
import chrome.tabs.bindings.Tab
import chrome.utils.ErrorHandling._

import scala.concurrent.{Future, Promise}
import scalajs.js

object PageAction {

  val onClicked: EventSource[Tab] = bindings.PageAction.onClicked

  def show(tabId: Tab.Id): Unit =
    bindings.PageAction.show(tabId)

  def hide(tabId: Tab.Id): Unit =
    bindings.PageAction.hide(tabId)

  def setTitle(details: SetTitleDetails): Unit =
    bindings.PageAction.setTitle(details)

  def getTitle(details: GetTitleDetails): Future[String] = {
    val promise = Promise[String]()
    bindings.PageAction.getTitle(details, js.Any.fromFunction1((title) => {
      promise.complete(lastErrorOrValue(title))
    }))
    promise.future
  }

  def setIcon(details: SetIconDetails): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.PageAction.setIcon(details, js.Any.fromFunction0(() => {
      promise.complete(lastErrorOrValue(()))
    }))
    promise.future
  }

  def setPopup(details: SetPopupDetails): Unit =
    bindings.PageAction.setPopup(details)

  def getPopup(details: GetPopupDetails): Future[String] = {
    val promise = Promise[String]()
    bindings.PageAction.getPopup(details, js.Any.fromFunction1((popup) => {
      promise.complete(lastErrorOrValue(popup))
    }))
    promise.future
  }
}
