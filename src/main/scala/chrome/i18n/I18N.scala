package chrome.i18n

import scala.concurrent.{Future, Promise}
import scala.scalajs.js

object I18N {

  def getAcceptLanguages: Future[js.Array[String]] = {
    val promise = Promise[js.Array[String]]()
    bindings.I18N.getAcceptLanguages((languages: js.Array[String]) => {
      promise.complete(chrome.lastErrorOrValue(languages))
    })
    promise.future
  }

  def getMessage(messageName: String,
                 substitutions: String*): js.UndefOr[String] = bindings.I18N.getMessage(messageName, substitutions: _*)

  def getUILanguage: String = bindings.I18N.getUILanguage()

}
