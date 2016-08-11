package chrome.downloads.bindings


import scalajs.js

@js.native
trait FileIconOptions extends js.Object {
  def size: js.UndefOr[Int]
}

object FileIconOptions {
  def apply(size: js.UndefOr[Int] = js.undefined): FileIconOptions = {
    js.Dynamic.literal(
      size = size
    ).asInstanceOf[FileIconOptions]
  }
}
