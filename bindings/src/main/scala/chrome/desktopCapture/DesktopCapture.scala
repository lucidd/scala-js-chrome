package chrome.desktopCapture

import bindings._
import chrome.tabs.bindings.Tab
import scala.concurrent.{Promise, Future}
import scala.scalajs.js
import scala.scalajs.js.JSConverters._

class DesktopMediaRequest(id: DesktopMediaRequestId, val result: Future[StreamId]) {
  def cancel(): Unit = DesktopCapture.cancelChooseDesktopMedia(id)
}

object DesktopCapture {

  def chooseDesktopMedia(sources: List[DesktopCaptureSourceType],
                         targetTab: js.UndefOr[Tab]): DesktopMediaRequest = {
    val promise = Promise[StreamId]()
    val id = bindings.DesktopCapture.chooseDesktopMedia(sources.toJSArray, targetTab, (streamId: StreamId) => {
      promise.complete(chrome.lastErrorOrValue(streamId))
    })
    new DesktopMediaRequest(id, promise.future)
  }

  def cancelChooseDesktopMedia(desktopMediaRequestId: DesktopMediaRequestId): Unit =
    bindings.DesktopCapture.cancelChooseDesktopMedia(desktopMediaRequestId)

}
