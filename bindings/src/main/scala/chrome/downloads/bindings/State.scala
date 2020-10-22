package chrome.downloads.bindings

sealed trait State

object State {
  val in_progress: State = "in_progress".asInstanceOf[State]
  val interrupted: State = "interrupted".asInstanceOf[State]
  val complete: State = "complete".asInstanceOf[State]
}
