package chrome.webRequest.bindings

import scala.scalajs.js
import scala.scalajs.js.typedarray.ArrayBuffer


/**
  * Contains data uploaded in a URL request.
  *
  * @since Chrome 23.
  */
@js.native
trait UploadData extends js.Object {
  /** Optional. An ArrayBuffer with a copy of the data. */
  val bytes: js.UndefOr[ArrayBuffer]

  /** Optional. A string with the file's path and name. */
  val file: js.UndefOr[String]
}
