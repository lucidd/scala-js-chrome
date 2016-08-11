package chrome.downloads.bindings

sealed trait HttpMethod
object HttpMethod {
  val GET: HttpMethod = "GET".asInstanceOf[HttpMethod]
  val POST: HttpMethod = "POST".asInstanceOf[HttpMethod]
}
