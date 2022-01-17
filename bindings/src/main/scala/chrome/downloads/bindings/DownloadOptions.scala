package chrome.downloads.bindings

import scala.scalajs.js
import scala.scalajs.js.|.undefOr2jsAny

@js.native
trait DownloadOptions extends js.Object {
  def url: String
  def filename: js.UndefOr[String]
  def conflictAction: js.UndefOr[FilenameConflictAction]
  def saveAs: js.UndefOr[Boolean]
  def method: js.UndefOr[HttpMethod]
  def headers: js.UndefOr[js.Array[js.Object]]
  def body: js.UndefOr[String]
}

object DownloadOptions {

  def apply(
      url: String,
      filename: js.UndefOr[String] = js.undefined,
      conflictAction: js.UndefOr[FilenameConflictAction] = js.undefined,
      saveAs: js.UndefOr[Boolean] = js.undefined,
      method: js.UndefOr[HttpMethod] = js.undefined,
      headers: js.UndefOr[js.Array[HttpHeader]] = js.undefined,
      body: js.UndefOr[String] = js.undefined
  ): DownloadOptions = {
    js.Dynamic
      .literal(
        url = url,
        filename = filename,
        conflictAction = conflictAction.asInstanceOf[String],
        saveAs = saveAs,
        method = method.asInstanceOf[String],
        headers = headers,
        body = body
      )
      .asInstanceOf[DownloadOptions]
  }
}
