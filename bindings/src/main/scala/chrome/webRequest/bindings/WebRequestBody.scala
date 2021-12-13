package chrome.webRequest.bindings

import scala.scalajs.js

@js.native
trait WebRequestBody extends js.Object {

  /** Optional: Errors when obtaining request body data.
    */
  val error: js.UndefOr[String] = js.native

  /** Optional: If the request method is POST and the body is a sequence of key-value pairs encoded in UTF8, encoded as
    * either multipart/form-data, or application/x-www-form-urlencoded, this dictionary is present and for each key
    * contains the list of all values for that key. If the data is of another media type, or if it is malformed, the
    * dictionary is not present. An example value of this dictionary is {'key': ['value1', 'value2']}.
    */
  val formData: js.UndefOr[js.Dictionary[js.Array[String]]] = js.native

  /** Optional: If the request method is PUT or POST, and the body is not already parsed in formData, then the unparsed
    * request body elements are contained in this array.
    */
  val raw: js.UndefOr[js.Array[UploadData]] = js.native
}
