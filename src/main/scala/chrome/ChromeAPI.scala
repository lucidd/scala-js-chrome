package chrome

trait ChromeAPI {
  val name: String
  val requiredPermissions: List[String]
}

