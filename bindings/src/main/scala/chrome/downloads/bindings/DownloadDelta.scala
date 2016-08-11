package chrome.downloads.bindings

import scalajs.js

trait DownloadDelta {
  def	id: Int
  def url: js.UndefOr[Delta[String]]
  def finalUrl: js.UndefOr[Delta[String]]
  def filename: js.UndefOr[Delta[String]]
  def danger: js.UndefOr[Delta[String]]
  def mime: js.UndefOr[Delta[String]]
  def startTime: js.UndefOr[Delta[String]]
  def endTime: js.UndefOr[Delta[String]]
  def state: js.UndefOr[Delta[String]]
  def canResume: js.UndefOr[Delta[Boolean]]
  def paused: js.UndefOr[Delta[Boolean]]
  def error: js.UndefOr[Delta[String]]
  def totalBytes: js.UndefOr[Delta[Double]]
  def fileSize: js.UndefOr[Delta[Double]]
  def exists: js.UndefOr[Delta[Boolean]]
}
