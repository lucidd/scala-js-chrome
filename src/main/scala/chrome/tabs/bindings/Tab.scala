package chrome.tabs.bindings

import scala.scalajs.js

class Tab extends js.Object {

  def id: js.UndefOr[Int] = js.native
  def index: Int = js.native
  def windowId: Int = js.native
  def openerTabId: js.UndefOr[Int] = js.native

  def highlighted: Boolean = js.native
  def active: Boolean = js.native
  def pinned: Boolean = js.native
  
  def url: js.UndefOr[String] = js.native
  def title: js.UndefOr[String] = js.native
  def favIconUrl: js.UndefOr[String] = js.native
  def status: js.UndefOr[Tab.Status] = js.native
  
  def incognito: Boolean = js.native
  
  def width: js.UndefOr[Int] = js.native
  def height: js.UndefOr[Int] = js.native
  def sessionId: js.UndefOr[String] = js.native

}

object Tab {
  
  type Status = String
  
  object StatusValues {

    val LOADING: Status = "loading"
    val COMPLETE: Status = "complete"

  }

  type Id = Int
  
}

