package chrome.omnibox.bindings

import scala.scalajs.js

@js.native
trait DefaultSuggestion extends js.Object {

  val description: String = js.native

}

object DefaultSuggestion {

  def apply(description: String): DefaultSuggestion = {
    js.Dynamic
      .literal(
        description = description
      )
      .asInstanceOf[DefaultSuggestion]
  }

}
