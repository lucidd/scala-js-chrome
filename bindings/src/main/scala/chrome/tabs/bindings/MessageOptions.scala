package chrome.tabs.bindings

import scala.scalajs.js
import scala.scalajs.js.|.undefOr2jsAny

object MessageOptions {

  def apply(frameId: js.UndefOr[ConnectInfo.FrameID] = js.undefined): MessageOptions = {
    js.Dynamic
      .literal(
        frameId = frameId
      )
      .asInstanceOf[MessageOptions]
  }
}

@js.native
trait MessageOptions extends js.Object {
  def frameId: js.UndefOr[ConnectInfo.FrameID] = js.native
}
