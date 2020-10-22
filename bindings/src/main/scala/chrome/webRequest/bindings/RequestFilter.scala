package chrome.webRequest.bindings

import scala.scalajs.js

object RequestFilter {

  def apply(
      tabId: js.UndefOr[Int] = js.undefined,
      types: js.UndefOr[js.Array[String]] = js.undefined,
      urls: js.UndefOr[js.Array[String]] = js.undefined,
      windowId: js.UndefOr[Int] = js.undefined
  ): RequestFilter = {
    js.Dynamic
      .literal(
        tabId = tabId,
        types = types,
        urls = urls,
        windowId = windowId
      )
      .asInstanceOf[RequestFilter]
  }
}

@js.native
trait RequestFilter extends js.Object {

  val tabId: js.UndefOr[Int] = js.native

  /**
   * A list of request types. Requests that cannot match any of the types will be filtered out.
   * Each element one of: "main_frame", "sub_frame", "stylesheet", "script", "image", "object", "xmlhttprequest",
   * or "other"
   */
  val types: js.UndefOr[js.Array[String]] = js.native

  /** A list of URLs or URL patterns. Requests that cannot match any of the URLs will be filtered out. */
  val urls: js.UndefOr[js.Array[String]] = js.native

  val windowId: js.UndefOr[Int] = js.native
}
