package chrome.downloads.bindings

import scalajs.js

@js.native
trait Delta[T] extends js.Object {
  def previous: js.UndefOr[T] = js.native
  def current: js.UndefOr[T] = js.native
}
