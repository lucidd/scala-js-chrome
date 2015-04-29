package chrome.browser

import chrome.browser.bindings.OpenTabOptions

import scala.concurrent.{Future, Promise}
import scala.scalajs.js

object Browser {

  def openTab(url: String): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.Browser.openTab(OpenTabOptions(url = url), js.Any.fromFunction0(() => {
      promise.complete(chrome.lastErrorOrValue(()))
    }))
    promise.future
  }

}
