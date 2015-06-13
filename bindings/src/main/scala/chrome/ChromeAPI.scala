package chrome

import chrome.permissions.APIPermission

trait ChromeAPI {
  val requiredPermissions: Set[APIPermission]
}

