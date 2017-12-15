package chrome.webRequest.bindings

import scala.scalajs.js
import scala.scalajs.js.typedarray.ArrayBuffer

/**
  * An HTTP Header, represented as an object containing a key and either a value or a binaryValue.
  */
@js.native
trait HttpHeader extends js.Object {
  val name: String = js.native
  val value: js.UndefOr[String] = js.native
  val binaryValue: js.UndefOr[ArrayBuffer] = js.native
}