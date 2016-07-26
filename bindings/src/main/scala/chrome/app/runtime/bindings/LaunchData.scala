package chrome.app.runtime.bindings

import chrome.filesystem.bindings.FileEntry

import scala.scalajs.js

object LaunchData {

  type Source = String

  val APP_LAUNCHER: Source = "app_launcher"
  val NEW_TAB_PAGE: Source = "new_tab_page"
  val RELOAD: Source = "reload"
  val RESTART: Source = "restart"
  val LOAD_AND_LAUNCH: Source = "load_and_launch"
  val COMMAND_LINE: Source = "command_line"
  val FILE_HANDLER: Source = "file_handler"
  val URL_HANDLER: Source = "url_handler"
  val SYSTEM_TRAY: Source = "system_tray"
  val ABOUT_PAGE: Source = "about_page"
  val KEYBOARD: Source = "keyboard"
  val EXTENTIONS_PAGE: Source = "extensions_page"
  val MANAGEMENT_API: Source = "management_api"
  val EPHEMERAL_APP: Source = "ephemeral_app"
  val BACKGROUND: Source = "background"
  val KIOSK: Source = "kiosk"
  val CHROME_INTERNAL: Source = "chrome_internal"
  val TEST: Source = "test"

}

@js.native
trait FileHandler extends js.Object {

  val entry: FileEntry = js.native
  val `type`: String = js.native

}

@js.native
trait LaunchData extends js.Object {

  def id: js.UndefOr[String] = js.native

  def items: js.UndefOr[js.Array[FileHandler]] = js.native

  def url: js.UndefOr[String] = js.native

  def referrerUrl: js.UndefOr[String] = js.native

  def isKioskSession: js.UndefOr[Boolean] = js.native

  def source: js.UndefOr[LaunchData.Source] = js.native

}
