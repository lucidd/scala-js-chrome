package chrome.tabs.bindings

import chrome.sessions.bindings.Session
import chrome.windows.bindings.Window

import scala.scalajs.js

@js.native
trait Tab extends js.Object {

  def id: js.UndefOr[Tab.Id] = js.native

  def index: Int = js.native

  def windowId: Window.Id = js.native

  def openerTabId: js.UndefOr[Tab.Id] = js.native

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

  def sessionId: js.UndefOr[Session.Id] = js.native

}

object Tab {

  type Status = String
  type Id = Int

  object StatusValues {

    val LOADING: Status = "loading"
    val COMPLETE: Status = "complete"

  }

}
