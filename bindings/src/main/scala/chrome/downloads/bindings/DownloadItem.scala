package chrome.downloads.bindings

import scalajs.js

@js.native
trait DownloadItem extends js.Object {
  def id: Int = js.native
  def url: String = js.native
  def finalUrl: String = js.native
  def referrer: String = js.native
  def filename: String = js.native
  def incognito: Boolean = js.native
  def danger: DangerType = js.native
  def mime: String = js.native
  def startTime: String = js.native
  def endTime: js.UndefOr[String] = js.native
  def estimatedEndTime: js.UndefOr[String] = js.native
  def state: State = js.native
  def paused: Boolean = js.native
  def canResume: Boolean = js.native
  def error: js.UndefOr[InterruptReason] = js.native
  def bytesReceived: Double = js.native
  def totalBytes: Double = js.native
  def fileSize: Double = js.native
  def exists: Boolean = js.native
  def byExtensionId: js.UndefOr[String] = js.native
  def byExtensionName: js.UndefOr[String] = js.native
}

object DownloadItem {
  type Id = Int
}
