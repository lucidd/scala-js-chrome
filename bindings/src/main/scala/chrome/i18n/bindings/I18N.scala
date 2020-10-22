package chrome.i18n.bindings

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

@js.native
@JSGlobal("chrome.i18n")
object I18N extends js.Object {

  def getAcceptLanguages(callback: js.Function1[js.Array[String], _]): Unit =
    js.native

  def getMessage(
      messageName: String,
      substitutions: js.UndefOr[String | js.Array[String]] = js.undefined
  ): js.UndefOr[String] = js.native

  def getUILanguage(): String = js.native

}
