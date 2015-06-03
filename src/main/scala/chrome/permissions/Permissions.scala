package chrome.permissions

import chrome.events.EventSource
import chrome.events.EventSourceImplicits._
import chrome.permissions.bindings._

import scala.concurrent.{Future, Promise}
import scala.scalajs.js

object Permissions {

  val onAdded: EventSource[PermissionList] = bindings.Permissions.onAdded
  val onRemoved: EventSource[PermissionList] = bindings.Permissions.onRemoved

  def getAll: Future[js.Array[Permission]] = {
    val promise = Promise[js.Array[Permission]]()
    bindings.Permissions.getAll((perms: PermissionList) => {
      promise.complete(chrome.lastErrorOrValue({
        val apiPerms = for {
          perm <- perms.permissions.getOrElse(js.Array())
          result <- string2Permission(perm)
        } yield result

        val hostPerms = for {
          pattern <- perms.origins.getOrElse(js.Array())
        } yield new HostPermission(pattern)

        apiPerms ++ hostPerms
      }))
    })
    promise.future
  }

  private def string2Permission(perm: String): Option[APIPermission] = {
    import APIPermission._
    perm match {
      case Tabs.name => Some(Tabs)
      case System.Display.name => Some(System.Display)
      case System.CPU.name => Some(System.CPU)
      case TTS.name => Some(TTS)
      case _ => None
    }
  }

  def contains(permissions: Permission*): Future[Boolean] = {
    val promise = Promise[Boolean]()
    val (api, host) = permissions2PermissionList(permissions)
    bindings.Permissions.contains(PermissionList(api, host), (result: Boolean) => {
      promise.complete(chrome.lastErrorOrValue(result))
    })
    promise.future
  }

  private def permissions2PermissionList[A <: Seq[Permission]](permissions: A): (js.Array[String], js.Array[String]) = {
    permissions.foldLeft((js.Array[String](), js.Array[String]())) { (acc, p) =>
      p match {
        case api: APIPermission => acc._1.append(api.name)
        case host: HostPermission => acc._2.append(host.urlPattern)
      }
      acc
    }
  }

  def request(permissions: Permission*): Future[Boolean] = {
    val promise = Promise[Boolean]()
    val (api, host) = permissions2PermissionList(permissions)
    bindings.Permissions.request(PermissionList(api, host), js.Any.fromFunction1((result: Boolean) => {
      promise.complete(chrome.lastErrorOrValue(result))
    }))
    promise.future
  }

  def remove(permissions: Permission*): Future[Boolean] = {
    val promise = Promise[Boolean]()
    val (api, host) = permissions2PermissionList(permissions)
    bindings.Permissions.remove(PermissionList(api, host), js.Any.fromFunction1((result: Boolean) => {
      promise.complete(chrome.lastErrorOrValue(result))
    }))
    promise.future
  }

}


