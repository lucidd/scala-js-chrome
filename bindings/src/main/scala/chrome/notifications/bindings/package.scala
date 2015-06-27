package chrome.notifications

package object bindings {

  type TemplateType = String
  object TemplateType {
    val BASIC: TemplateType = "basic"
    val IMAGE: TemplateType = "image"
    val LIST: TemplateType = "list"
    val PROGRESS: TemplateType = "progress"
  }

  type PermissionLevel = String
  object PermissionLevel {
    val GRANTED: PermissionLevel = "granted"
    val DENIED: PermissionLevel = "denied"
  }

}
