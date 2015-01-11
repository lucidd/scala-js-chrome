package chrome.windows.bindings

import scala.scalajs.js

class Window extends js.Object {

}

object Window {

  type Id = Int

  type Type = String

  object Types {

    val NORMAL: Type = "normal"
    val POPUP: Type = "popup"
    val PANEL: Type = "panel"
    val APP: Type = "app"

  }
  
}