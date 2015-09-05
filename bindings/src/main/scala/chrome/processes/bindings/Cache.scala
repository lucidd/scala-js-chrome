package chrome.processes.bindings

import scala.scalajs.js

@js.native
trait Cache extends js.Object {

  val size: Double = js.native
  val liveSize: Double = js.native

}
