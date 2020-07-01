package com.alexitc

import chrome.permissions.Permission
import chrome.permissions.Permission.API
import chrome.{Background, BrowserAction, ContentScript, ExtensionManifest, PageAction}
import org.scalatest.matchers.must.Matchers._
import org.scalatest.wordspec.AnyWordSpec

class JsonCodecsSpec extends AnyWordSpec {
  import JsonCodecs._
  import OptionPickler._

  "The extension manifest" should {
    "get rendered properly with browser action" in {
      val expected =
        """
{"manifest_version":2,"name":"__MSG_extensionName__","version":"1.0.0","default_locale":"en","description":"TO BE UPDATED","icons":{"48":"icons/48/app.png","96":"icons/96/app.png","128":"icons/128/app.png"},"web_accessible_resources":["icons/*"],"permissions":["storage","notifications","alarms"],"background":{"scripts":["scripts/common.js","dependencies.js","main.js","scripts/background-script.js"]},"browser_action":{"default_title":"TO BE DEFINED - POPUP TITLE","default_popup":"popup.html","default_icon":{"48":"icons/48/app.png","96":"icons/96/app.png","128":"icons/128/app.png"}},"content_scripts":[{"matches":["https://github.com/*"],"css":["css/active-tab.css"],"js":["scripts/common.js","dependencies.js","main.js","scripts/active-tab-script.js"]}]}
""".stripMargin.trim

      val manifest: chrome.Manifest = new ExtensionManifest {
        override val name = "__MSG_extensionName__"
        override val version = "1.0.0"
        override val description = Some("TO BE UPDATED")
        override val icons = Chrome.icons("icons", "app.png", Set(48, 96, 128))
        override val permissions =
          Set[Permission](API.Storage, API.Notifications, API.Alarms)

        override val defaultLocale: Option[String] = Some("en")
        override val browserAction: Option[BrowserAction] = Some(
          BrowserAction(
            icons,
            Some("TO BE DEFINED - POPUP TITLE"),
            Some("popup.html")
          )
        )

        val commonScripts =
          List("scripts/common.js", "dependencies.js", "main.js")

        override val background = Background(
          scripts = commonScripts ::: List("scripts/background-script.js")
        )

        override val contentScripts: List[ContentScript] = List(
          ContentScript(
            matches = List(
              "https://github.com/*" // TODO: REPLACE ME
            ),
            css = List("css/active-tab.css"),
            js = commonScripts ::: List("scripts/active-tab-script.js")
          )
        )

        override val webAccessibleResources = List("icons/*")
      }

      val contentJson = writeJs(manifest).dropNullValues.getOrElse(ujson.Obj())
      val result = write(contentJson)
      result must be(expected)
    }

    "get rendered properly with page actions" in {
      val expected =
        """
{"manifest_version":2,"name":"__MSG_extensionName__","version":"1.0.0","default_locale":"en","description":"TO BE UPDATED","icons":{"48":"icons/48/app.png","96":"icons/96/app.png","128":"icons/128/app.png"},"web_accessible_resources":["icons/*"],"permissions":["storage","notifications","alarms"],"background":{"scripts":["scripts/common.js","dependencies.js","main.js","scripts/background-script.js"]},"page_action":{"default_title":"TO BE DEFINED - POPUP TITLE","default_popup":"popup.html","default_icon":{"48":"icons/48/app.png","96":"icons/96/app.png","128":"icons/128/app.png"}},"content_scripts":[{"matches":["https://github.com/*"],"css":["css/active-tab.css"],"js":["scripts/common.js","dependencies.js","main.js","scripts/active-tab-script.js"]}]}
""".stripMargin.trim

      val manifest: chrome.Manifest = new ExtensionManifest {
        override val name = "__MSG_extensionName__"
        override val version = "1.0.0"
        override val description = Some("TO BE UPDATED")
        override val icons = Chrome.icons("icons", "app.png", Set(48, 96, 128))
        override val permissions =
          Set[Permission](API.Storage, API.Notifications, API.Alarms)

        override val defaultLocale: Option[String] = Some("en")
        override val pageAction: Option[PageAction] = Some(
          PageAction(
            icons,
            Some("TO BE DEFINED - POPUP TITLE"),
            Some("popup.html")
          )
        )

        val commonScripts =
          List("scripts/common.js", "dependencies.js", "main.js")

        override val background = Background(
          scripts = commonScripts ::: List("scripts/background-script.js")
        )

        override val contentScripts: List[ContentScript] = List(
          ContentScript(
            matches = List(
              "https://github.com/*" // TODO: REPLACE ME
            ),
            css = List("css/active-tab.css"),
            js = commonScripts ::: List("scripts/active-tab-script.js")
          )
        )

        override val webAccessibleResources = List("icons/*")
      }

      val contentJson = writeJs(manifest).dropNullValues.getOrElse(ujson.Obj())
      val result = write(contentJson)
      result must be(expected)
    }
  }
}
