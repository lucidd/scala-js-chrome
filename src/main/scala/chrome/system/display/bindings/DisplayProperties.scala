package chrome.system.display.bindings

import scala.scalajs.js

object DisplayProperties {

  def apply(mirroringSourceId: js.UndefOr[Display.ID] = js.undefined,
            isPrimary: js.UndefOr[Boolean] = js.undefined,
            overscan: js.UndefOr[Insets] = js.undefined,
            rotation: js.UndefOr[Int] = js.undefined,
            boundsOriginX: js.UndefOr[Int] = js.undefined,
            boundsOriginY: js.UndefOr[Int] = js.undefined
             ): DisplayProperties = {
    js.Dynamic.literal(
      mirroringSourceId = mirroringSourceId,
      isPrimary = isPrimary,
      overscan = overscan,
      rotation = rotation,
      boundsOriginX = boundsOriginX,
      boundsOriginY = boundsOriginY
    ).asInstanceOf[DisplayProperties]
  }

}

class DisplayProperties extends js.Object {

  var mirroringSourceId: js.UndefOr[Display.ID] = js.native
  var isPrimary: js.UndefOr[Boolean] = js.native
  var overscan: js.UndefOr[Insets] = js.native
  var rotation: js.UndefOr[Int] = js.native
  var boundsOriginX: js.UndefOr[Int] = js.native
  var boundsOriginY: js.UndefOr[Int] = js.native

}
