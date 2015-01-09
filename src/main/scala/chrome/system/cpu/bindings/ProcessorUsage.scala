package chrome.system.cpu.bindings

import scala.scalajs.js

class ProcessorUsage extends js.Object {

  def user: Double = js.native
  def kernel: Double = js.native
  def idle: Double = js.native
  def total: Double = js.native

}
