package chrome.downloads.bindings

import scala.scalajs.js

@js.native
sealed trait HttpHeader extends js.Object

@js.native
trait Header extends HttpHeader {
  def name: String
  def value: String
}

object Header {

  def apply(name: String, value: String): Header = {
    js.Dynamic
      .literal(
        name = name,
        value = value
      )
      .asInstanceOf[Header]
  }
}

@js.native
trait BinaryHeader extends HttpHeader {
  def name: String
  def binaryValue: String
}

object BinaryHeader {

  def apply(name: String, binaryValue: String): Header = {
    js.Dynamic
      .literal(
        name = name,
        binaryValue = binaryValue
      )
      .asInstanceOf[Header]
  }
}
