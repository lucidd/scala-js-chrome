package chrome.downloads.bindings

sealed trait FilenameConflictAction

object FilenameConflictAction {
  val uniquify: FilenameConflictAction = "uniquify".asInstanceOf[FilenameConflictAction]
  val overwrite: FilenameConflictAction = "overwrite".asInstanceOf[FilenameConflictAction]
  val prompt: FilenameConflictAction = "prompt".asInstanceOf[FilenameConflictAction]
}
