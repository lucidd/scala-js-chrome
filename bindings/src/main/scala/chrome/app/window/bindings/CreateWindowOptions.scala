package chrome.app.window.bindings

import scala.scalajs.js

object CreateWindowOptions {

  def apply(id: js.UndefOr[String] = js.undefined,
            innerBounds: js.UndefOr[BoundsSpecification] = js.undefined,
            outerBounds: js.UndefOr[BoundsSpecification] = js.undefined,
            alphaEnabled: js.UndefOr[Boolean] = js.undefined,
            state: js.UndefOr[String] = js.undefined,
            hidden: js.UndefOr[Boolean] = js.undefined,
            resizable: js.UndefOr[Boolean] = js.undefined,
            alwaysOnTop: js.UndefOr[Boolean] = js.undefined,
            focused: js.UndefOr[Boolean] = js.undefined,
            visibleOnAllWorkspaces: js.UndefOr[Boolean] = js.undefined)
    : CreateWindowOptions = {
    js.Dynamic
      .literal(
          id = id,
          alphaEnabled = alphaEnabled,
          state = state,
          hidden = hidden,
          resizable = resizable,
          alwaysOnTop = alwaysOnTop,
          focused = focused,
          visibleOnAllWorkspaces = visibleOnAllWorkspaces
      )
      .asInstanceOf[CreateWindowOptions]
  }

}

@js.native
trait CreateWindowOptions extends js.Object {

  val alphaEnabled: js.UndefOr[Boolean] = js.native
  val state: js.UndefOr[String] = js.native
  val hidden: js.UndefOr[Boolean] = js.native
  val resizable: js.UndefOr[Boolean] = js.native
  val alwaysOnTop: js.UndefOr[Boolean] = js.native
  val focused: js.UndefOr[Boolean] = js.native
  val visibleOnAllWorkspaces: js.UndefOr[Boolean] = js.native
  var id: js.UndefOr[String] = js.native
  var innerBounds: js.UndefOr[BoundsSpecification] = js.native
  var outerBounds: js.UndefOr[BoundsSpecification] = js.native

}
