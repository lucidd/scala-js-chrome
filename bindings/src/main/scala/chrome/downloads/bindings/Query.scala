package chrome.downloads.bindings

import scala.scalajs.js

@js.native
trait Query extends js.Object {
  def query: js.UndefOr[js.Array[String]]
  def startedBefore: js.UndefOr[String]
  def startedAfter: js.UndefOr[String]
  def endedBefore: js.UndefOr[String]
  def endedAfter: js.UndefOr[String]
  def totalBytesGreater: js.UndefOr[Double]
  def totalBytesLess: js.UndefOr[Double]
  def filenameRegex: js.UndefOr[String]
  def urlRegex: js.UndefOr[String]
  def finalUrlRegex: js.UndefOr[String]
  def limit: js.UndefOr[Int]
  def orderBy: js.UndefOr[js.Array[String]]
  def id: js.UndefOr[Int]
  def url: js.UndefOr[String]
  def finalUrl: js.UndefOr[String]
  def filename: js.UndefOr[String]
  def danger: js.UndefOr[DangerType]
  def mime: js.UndefOr[String]
  def startTime: js.UndefOr[String]
  def endTime: js.UndefOr[String]
  def state: js.UndefOr[State]
  def paused: js.UndefOr[Boolean]
  def error: js.UndefOr[InterruptReason]
  def bytesReceived: js.UndefOr[Double]
  def totalBytes: js.UndefOr[Double]
  def fileSize: js.UndefOr[Double]
  def exists: js.UndefOr[Boolean]
}

object Query {

  def apply(
      query: js.UndefOr[js.Array[String]] = js.undefined,
      startedBefore: js.UndefOr[String] = js.undefined,
      startedAfter: js.UndefOr[String] = js.undefined,
      endedBefore: js.UndefOr[String] = js.undefined,
      endedAfter: js.UndefOr[String] = js.undefined,
      totalBytesGreater: js.UndefOr[Double] = js.undefined,
      totalBytesLess: js.UndefOr[Double] = js.undefined,
      filenameRegex: js.UndefOr[String] = js.undefined,
      urlRegex: js.UndefOr[String] = js.undefined,
      finalUrlRegex: js.UndefOr[String] = js.undefined,
      limit: js.UndefOr[Int] = js.undefined,
      orderBy: js.UndefOr[js.Array[String]] = js.undefined,
      id: js.UndefOr[Int] = js.undefined,
      url: js.UndefOr[String] = js.undefined,
      finalUrl: js.UndefOr[String] = js.undefined,
      filename: js.UndefOr[String] = js.undefined,
      danger: js.UndefOr[DangerType] = js.undefined,
      mime: js.UndefOr[String] = js.undefined,
      startTime: js.UndefOr[String] = js.undefined,
      endTime: js.UndefOr[String] = js.undefined,
      state: js.UndefOr[State] = js.undefined,
      paused: js.UndefOr[Boolean] = js.undefined,
      error: js.UndefOr[InterruptReason] = js.undefined,
      bytesReceived: js.UndefOr[Double] = js.undefined,
      totalBytes: js.UndefOr[Double] = js.undefined,
      fileSize: js.UndefOr[Double] = js.undefined,
      exists: js.UndefOr[Boolean] = js.undefined
  ): DownloadOptions = {
    js.Dynamic
      .literal(
        query = query,
        startedBefore = startedBefore,
        startedAfter = startedAfter,
        endedBefore = endedBefore,
        endedAfter = endedAfter,
        totalBytesGreater = totalBytesGreater,
        totalBytesLess = totalBytesLess,
        filenameRegex = filenameRegex,
        urlRegex = urlRegex,
        finalUrlRegex = finalUrlRegex,
        limit = limit,
        orderBy = orderBy,
        id = id,
        url = url,
        finalUrl = finalUrl,
        filename = filename,
        danger = danger.asInstanceOf[String],
        mime = mime,
        startTime = startTime,
        endTime = endTime,
        state = state.asInstanceOf[String],
        paused = paused,
        error = error.asInstanceOf[String],
        bytesReceived = bytesReceived,
        totalBytes = totalBytes,
        fileSize = fileSize,
        exists = exists
      )
      .asInstanceOf[DownloadOptions]
  }
}
