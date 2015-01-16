package chrome.system.cpu.bindings

import scala.scalajs.js

class Processor extends js.Object {
  
  def usage: Processor.Usage = js.native
  
}

object Processor {

  class Usage extends js.Object {

    def user: Double = js.native
    def kernel: Double = js.native
    def idle: Double = js.native
    def total: Double = js.native

  }
  
}


