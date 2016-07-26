package chrome.idle

package object bindings {

  type State = String

  object State {
    val ACTIVE: State = "active"
    val IDLE: State = "idle"
    val LOCKED: State = "locked"
  }

}
