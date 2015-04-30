package chrome.desktopCapture


package object bindings {

  type DesktopMediaRequestId = Int
  type StreamId = String

  type DesktopCaptureSourceType = String

  object DesktopCaptureSourceType {
    val SCREEN: DesktopCaptureSourceType = "screen"
    val WINDOW: DesktopCaptureSourceType = "window"
    val TAB: DesktopCaptureSourceType = "tab"
  }

}
