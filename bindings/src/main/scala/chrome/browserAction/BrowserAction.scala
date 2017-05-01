package chrome.browserAction

import chrome.browserAction.bindings._
import chrome.events.bindings.Event
import chrome.tabs.bindings.Tab
import org.scalajs.dom.ImageData

import scala.concurrent.{Future, Promise}
import scala.scalajs.js
import scala.scalajs.js.|

object BrowserAction {
  val onClicked: Event[js.Function1[Tab, _]] = bindings.BrowserAction.onClicked

  def setTitle(title: String, tabId: js.UndefOr[Int] = js.undefined): Unit = {
    bindings.BrowserAction.setTitle(TitleDetails(title, tabId))
  }

  def getTitle(tabId: js.UndefOr[Int] = js.undefined): Future[String] = {
    val promise = Promise[String]()
    bindings.BrowserAction.getTitle(TabIdDetails(tabId), (result: String) => {
      promise.success(result)
    })
    promise.future
  }

  def setIconImageData(imageData: js.UndefOr[ImageData | js.Dictionary[ImageData]],
                       tabId: js.UndefOr[Int] = js.undefined): Future[Unit] = {
    setIcon(imageData, js.undefined, tabId)
  }

  def setIconPath(pathData: js.UndefOr[String | js.Dictionary[String]],
                  tabId: js.UndefOr[Int] = js.undefined): Future[Unit] = {
    setIcon(js.undefined, pathData, tabId)
  }

  def setIcon(imageData: js.UndefOr[ImageData | js.Dictionary[ImageData]],
              pathData: js.UndefOr[String | js.Dictionary[String]],
              tabId: js.UndefOr[Int]): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.BrowserAction.setIcon(IconDetails(imageData, pathData, tabId), () => {
      promise.success(())
    })

    promise.future
  }

  def setPopup(popup: String, tabId: js.UndefOr[Int] = js.undefined): Unit = {
    bindings.BrowserAction.setPopup(PopupDetails(popup, tabId))
  }

  def getPopup(tabId: js.UndefOr[Int] = js.undefined): Future[String] = {
    val promise = Promise[String]()
    bindings.BrowserAction.getPopup(TabIdDetails(tabId), (result: String) => {
      promise.success(result)
    })
    promise.future
  }

  def setBadgeText(text: String, tabId: js.UndefOr[Int] = js.undefined): Unit = {
    bindings.BrowserAction.setBadgeText(BadgeTextDetails(text, tabId))
  }

  def getBadgeText(tabId: js.UndefOr[Int] = js.undefined): Future[String] = {
    val promise = Promise[String]()
    bindings.BrowserAction.getBadgeText(TabIdDetails(tabId), (result: String) => {
      promise.success(result)
    })
    promise.future
  }

  def setBadgeBackgroundColor(color: String | js.Array[Int]): Unit = {
    bindings.BrowserAction.setBadgeBackgroundColor(BadgeBackgroundColorDetails(color))
  }

  def getBadgeBackgroundColor(tabId: js.UndefOr[Int] = js.undefined): Future[js.Array[Int]] = {
    val promise = Promise[js.Array[Int]]()
    bindings.BrowserAction.getBadgeBackgroundColor(TabIdDetails(tabId), (result: js.Array[Int]) => {
      promise.success(result)
    })
    promise.future
  }

  def enable(tabId: js.UndefOr[Int]): Unit = {
    bindings.BrowserAction.enable(tabId)
  }

  def disable(tabId: js.UndefOr[Int]): Unit = {
    bindings.BrowserAction.disable(tabId)
  }
}
