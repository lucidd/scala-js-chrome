package chrome.filesystem.bindings

import scala.scalajs.js

class FileEntry extends js.Object {

  val fullPath: String = js.native
  val isDirectory: Boolean = js.native
  val isFile: Boolean = js.native
  val name: String = js.native

}
