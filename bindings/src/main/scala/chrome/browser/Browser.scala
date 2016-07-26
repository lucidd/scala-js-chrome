package chrome.browser

import chrome.ChromeAPI
import chrome.browser.bindings.OpenTabOptions
import chrome.permissions.Permission.API
import chrome.utils.ErrorHandling._

import scala.concurrent.{Future, Promise}
import scala.scalajs.js

object Browser extends ChromeAPI {

  val requiredPermissions: Set[API] = Set(API.Browser)

  def openTab(url: String): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.Browser
      .openTab(OpenTabOptions(url = url), js.Any.fromFunction0(() => {
        promise.complete(lastErrorOrValue(()))
      }))
    promise.future
  }

}
