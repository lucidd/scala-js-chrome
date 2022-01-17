package chrome.tabs.bindings

import scala.scalajs.js
import scala.scalajs.js.|.undefOr2jsAny

object ConnectInfo {

  // TODO: find a better place for this
  type FrameID = Int

  def apply(name: js.UndefOr[String] = js.undefined, frameId: js.UndefOr[FrameID] = js.undefined): ConnectInfo = {
    js.Dynamic
      .literal(
        name = name,
        frameId = frameId
      )
      .asInstanceOf[ConnectInfo]
  }

}

@js.native
trait ConnectInfo extends js.Object {

  def name: js.UndefOr[String] = js.native

  def frameId: js.UndefOr[ConnectInfo.FrameID] = js.native

}
