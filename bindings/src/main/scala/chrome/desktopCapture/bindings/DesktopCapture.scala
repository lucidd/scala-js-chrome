package chrome.desktopCapture.bindings

import chrome.tabs.bindings.Tab

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
@JSName("chrome.desktopCapture")
object DesktopCapture extends js.Object {

  def chooseDesktopMedia(sources: js.Array[DesktopCaptureSourceType],
                         targetTab: js.UndefOr[Tab],
                         callback: js.Function1[StreamId, _]): DesktopMediaRequestId = js.native

  def cancelChooseDesktopMedia(desktopMediaRequestId: DesktopMediaRequestId): Unit = js.native

}
