package chrome.i18n

import scala.concurrent.{Future, Promise}
import scala.scalajs.js
import chrome.utils.ErrorHandling._

import js.JSConverters._
import scala.scalajs.js.|

object I18N {

  def getAcceptLanguages: Future[js.Array[String]] = {
    val promise = Promise[js.Array[String]]()
    bindings.I18N.getAcceptLanguages((languages: js.Array[String]) => {
      promise.complete(lastErrorOrValue(languages))
    })
    promise.future
  }

  def getMessage(messageName: String, substitutions: String*): js.UndefOr[String] = {
    if(substitutions.isEmpty) {
      bindings.I18N.getMessage(messageName)
    } else {
      val jsArraySubstitutions = substitutions.toJSArray.asInstanceOf[String | js.Array[String]]
      bindings.I18N.getMessage(messageName, Some(jsArraySubstitutions).orUndefined)
    }
  }

  def getUILanguage: String = bindings.I18N.getUILanguage()

}
