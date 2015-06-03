package chrome.permissions

import scala.concurrent.Future

sealed trait Permission {
  def granted: Future[Boolean] = Permissions.contains(this)
  def request: Future[Boolean] = Permissions.request(this)
  def drop: Future[Boolean] = Permissions.remove(this)
}

class HostPermission(val urlPattern: String) extends Permission

sealed trait APIPermission extends Permission {
  val name: String
  val description: String
}

object APIPermission {

  object Tabs extends APIPermission {
    val name = "tabs"
    val description = ""
  }

  object Notifications extends APIPermission {
    val name = "notifications"
    val description = ""
  }

  object System {

    object CPU extends APIPermission {
      val name = "system.cpu"
      val description = ""
    }

    object Display extends APIPermission {
      val name = "system.display"
      val description = ""
    }

    object Memory extends APIPermission {
      val name = "system.memory"
      val description = ""
    }

    object Network extends APIPermission {
      val name = "system.network"
      val description = ""
    }

  }

  object TTS extends APIPermission {
    val name = "tts"
    val description = ""
  }

  object Alarms extends APIPermission {
    val name = "alarms"
    val description = ""
  }

  object Browser extends APIPermission {
    val name = "browser"
    val description = ""
  }

  object Idle extends APIPermission {
    val name = "idle"
    val description = ""
  }

  object Power extends APIPermission {
    val name = "power"
    val description = ""
  }

  object Management extends APIPermission {
    val name = "management"
    val description = ""
  }

  object Experimental extends APIPermission {
    val name = "experimental"
    val description = ""
  }

  object Identity extends APIPermission {
    val name = "identity"
    val description = ""
  }

  object GCM extends APIPermission {
    val name = "gcm"
    val description = ""
  }

  object Location extends APIPermission {
    val name = "location"
    val description = ""
  }

  object Sessions extends APIPermission {
    val name = "Sessions"
    val description = ""
  }

  object Proxy extends APIPermission {
    val name = "proxy"
    val description = ""
  }

  object Processes extends APIPermission {
    val name = "processes"
    val description = ""
  }

  object Privacy extends APIPermission {
    val name = "privacy"
    val description = ""
  }

  object Cookies extends APIPermission {
    val name = "cookies"
    val description = ""
  }

}

