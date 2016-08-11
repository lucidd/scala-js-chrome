package chrome.downloads.bindings

import chrome.events.bindings.Event

import scala.scalajs.js.annotation.JSName
import scalajs.js

@js.native
@JSName("chrome.downloads")
object Downloads extends js.Object {

  type Suggest = Option[Suggestion] => Unit

  val onCreated: Event[js.Function1[DownloadItem, _]] = js.native
  val onErased: Event[js.Function1[DownloadItem.Id, _]] = js.native
  val onChanged: Event[js.Function1[DownloadDelta, _]] = js.native
  val onDeterminingFilename: Event[js.Function2[DownloadItem, Suggest, _]] = js.native

  def download(options: DownloadOptions, callback: js.UndefOr[js.Function1[DownloadItem.Id, _]] = js.native): Unit = js.native

  def pause(id: DownloadItem.Id, callback: js.UndefOr[js.Function0[_]] = js.native): Unit = js.native
  def resume(id: DownloadItem.Id, callback: js.UndefOr[js.Function0[_]] = js.native): Unit = js.native
  def cancel(id: DownloadItem.Id, callback: js.UndefOr[js.Function0[_]] = js.native): Unit = js.native
  def getFileIcon(
       id: DownloadItem.Id,
       options: js.UndefOr[FileIconOptions] = js.native,
       callback: js.UndefOr[js.Function1[js.UndefOr[String], _]]
  ): Unit = js.native
  def open(id: DownloadItem.Id): Unit = js.native
  def show(id: DownloadItem.Id): Unit = js.native
  def showDefaultFolder(): Unit = js.native

  def erase(query: Query, callback: js.UndefOr[js.Function1[js.Array[DownloadItem.Id], _]] = js.native): Unit = js.native
  def search(query: Query, callback: js.Function1[js.Array[DownloadItem], _]): Unit = js.native

  def removeFile(id: DownloadItem.Id, callback: js.UndefOr[js.Function0[_]] = js.native): Unit = js.native
  def acceptDanger(id: DownloadItem.Id, callback: js.UndefOr[js.Function0[_]] = js.native): Unit = js.native
  def drag(id: DownloadItem.Id): Unit = js.native
  def setShelfEnabled(enabled: Boolean): Unit = js.native

}
