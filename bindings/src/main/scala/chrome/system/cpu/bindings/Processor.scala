package chrome.system.cpu.bindings

import scala.scalajs.js

class Processor extends js.Object {

  def usage: Processor.Usage = js.native

}

object Processor {

  class Usage extends js.Object {

    val user: Double = js.native
    val kernel: Double = js.native
    val idle: Double = js.native
    val total: Double = js.native

  }

}


