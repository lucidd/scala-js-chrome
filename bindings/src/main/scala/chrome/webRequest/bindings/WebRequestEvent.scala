package chrome.webRequest.bindings

import scala.scalajs.js

@js.native
trait WebRequestEvent[-T <: js.Function] extends js.Object {

  def addListener(
      callback: T,
      filter: RequestFilter,
      opt_extraInfoSpec: js.UndefOr[js.Array[String]] = js.undefined
  ): Unit = js.native

  def removeListener(callback: T): Unit = js.native

  def hasListener(callback: T): Boolean = js.native

  def hasListeners(): Boolean = js.native
}
