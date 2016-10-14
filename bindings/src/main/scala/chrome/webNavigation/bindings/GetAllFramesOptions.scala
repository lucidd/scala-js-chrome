package chrome.webNavigation.bindings

import chrome.tabs.bindings.Tab

import scala.scalajs.js

@js.native
trait GetAllFramesOptions extends js.Object {
  /**
    * The ID of the tab.
    */
  val tabId: Tab.Id
}

object GetAllFramesOptions {
  def apply(tabId: Tab.Id): GetAllFramesOptions =
    js.Dynamic.literal(
      tabId = tabId
    ).asInstanceOf[GetAllFramesOptions]
}