package chrome.omnibox


package object bindings {

  type DescriptionStyleType = String

  object DescriptionStyleType {
    val URL: DescriptionStyleType = "url"
    val MATCH: DescriptionStyleType = "match"
    val DIM: DescriptionStyleType = "dim"
  }

  type OnInputEnteredDisposition = String

  object OnInputEnteredDisposition {
    val CURRENT_TAB: OnInputEnteredDisposition = "currentTab"
    val NEW_FOREGROUND_TAB: OnInputEnteredDisposition = "newForegroundTab"
    val NEW_BACKGROUND_TAB: OnInputEnteredDisposition = "newBackgroundTab"
  }

}
