package chrome.omnibox.bindings

import scala.scalajs.js

class SuggestResult extends js.Object {

  val content: String = js.native
  val description: String = js.native

}


object SuggestResult {

  def apply(content: String, description: String): SuggestResult = {
    js.Dynamic.literal(
      content = content,
      description = description
    ).asInstanceOf[SuggestResult]
  }

}
