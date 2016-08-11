package chrome.downloads.bindings

import scalajs.js

@js.native
trait Suggestion extends js.Object {
  def filename: String
  def conflictAction: js.UndefOr[FilenameConflictAction]
}
