package chrome

import chrome.permissions.APIPermission

trait ChromeAPI {
  val requiredPermissions: List[APIPermission]
}

