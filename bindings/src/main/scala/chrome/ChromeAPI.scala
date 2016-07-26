package chrome

import chrome.permissions.Permission.API

trait ChromeAPI {
  val requiredPermissions: Set[API]
}
