package chrome.management.bindings

import scala.scalajs.js

class ExtensionInfo extends js.Object {

   
   
   val id: String = js.native
   val name: String = js.native
   val shortName: String = js.native
   val description: String = js.native
   val version: String = js.native
   val mayDisable: Boolean = js.native
   val enabled: Boolean = js.native
   val disabledReason: js.UndefOr[ExtensionInfo.DisableReason] = js.native
   val `type`:  ExtensionInfo.Type = js.native



   val homepageUrl: js.UndefOr[String] = js.native
   val updateUrl: js.UndefOr[String] = js.native
   val offlineEnabled: Boolean = js.native
   val optionsUrl: String = js.native
   val icons: js.UndefOr[js.Array[IconInfo]] = js.native
   val permissions: js.Array[String] = js.native
   val hostPermissions: js.Array[String] = js.native
   val installType: ExtensionInfo.InstallType = js.native


   //TODO: find a good way to make sure this can only be accessed if we are in a app (maybe using implicits)
   val appLaunchUrl: js.UndefOr[String] = js.native
   val launchType: js.UndefOr[ExtensionInfo.LaunchType] = js.native
   val availableLaunchTypes: js.UndefOr[js.Array[ExtensionInfo.LaunchType]] = js.native


 }

object ExtensionInfo {

   type DisableReason = String

   object DisableReasons {

      val UNKNOWN: DisableReason = "unknown"
      val PERMISSIONS_INCREASE: DisableReason = "permissions_increase"

   }
   
   type Type = String
   
   object Types {
      
      val EXTENSION: Type = "extension"
      val HOSTED_APP: Type = "hosted_app"
      val PACKAGED_APP: Type = "packaged_app"
      val LEGACY_PACKAGED_APP: Type = "legacy_packaged_app"
      val THEME: Type = "theme"

   }
   
   type InstallType = String
   
   object InstallTypes {
      
      val ADMIN: InstallType = "admin"
      val DEVELOPMENT: InstallType = "development"
      val NORMAL: InstallType = "normal"
      val SIDELOAD: InstallType = "sideload"
      val OTHER: InstallType = "other"
      
   }
   
   type LaunchType = String
   
   object LaunchTypes {

      val OPEN_AS_REGULAR_TAB: LaunchType = "OPEN_AS_REGULAR_TAB"
      val OPEN_AS_PINNED_TAB: LaunchType = "OPEN_AS_PINNED_TAB"
      val OPEN_AS_WINDOW: LaunchType = "OPEN_AS_WINDOW"
      val OPEN_FULL_SCREEN: LaunchType = "OPEN_FULL_SCREEN"

   }
   
}


