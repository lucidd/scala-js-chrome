package chrome.i18n.bindings

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@JSName("chrome.i18n")
object I18N extends js.Object {

  def getAcceptLanguages(callback: js.Function1[js.Array[String], _]): Unit = js.native
  def getMessage(messageName: String, substitutions: String*): js.UndefOr[String] = js.native
  def getUILanguage(): String = js.native

}
