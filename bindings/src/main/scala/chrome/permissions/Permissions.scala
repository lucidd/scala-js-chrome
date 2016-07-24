package chrome.permissions

import chrome.events.EventSource
import chrome.events.EventSourceImplicits._
import chrome.permissions.bindings._
import chrome.utils.ErrorHandling._

import scala.concurrent.{Future, Promise}
import scala.scalajs.js

object Permissions {

  implicit class PermissionOps(val permission: Permission) extends AnyVal {
    def granted: Future[Boolean] = Permissions.contains(permission)
    def request: Future[Boolean] = Permissions.request(permission)
    def drop: Future[Boolean] = Permissions.remove(permission)
  }

  val onAdded: EventSource[PermissionList] = bindings.Permissions.onAdded
  val onRemoved: EventSource[PermissionList] = bindings.Permissions.onRemoved

  def getAll: Future[js.Array[Permission]] = {
    val promise = Promise[js.Array[Permission]]()
    bindings.Permissions.getAll((perms: PermissionList) => {
      promise.complete(lastErrorOrValue({
        val apiPerms = for {
          perm <- perms.permissions.getOrElse(js.Array())
          result <- permissionFromString(perm)
        } yield result

        val hostPerms = for {
          pattern <- perms.origins.getOrElse(js.Array())
        } yield new HostPermission(pattern)

        apiPerms ++ hostPerms
      }))
    })
    promise.future
  }

  def permissionFromString(perm: String): Option[Permission] = {
    APIPermission.All.get(perm).orElse(Some(HostPermission(perm)))
  }

  def contains(permissions: Permission*): Future[Boolean] = {
    val promise = Promise[Boolean]()
    val (api, host) = permissions2PermissionList(permissions)
    bindings.Permissions.contains(PermissionList(api, host), (result: Boolean) => {
      promise.complete(lastErrorOrValue(result))
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
      promise.complete(lastErrorOrValue(result))
    }))
    promise.future
  }

  def remove(permissions: Permission*): Future[Boolean] = {
    val promise = Promise[Boolean]()
    val (api, host) = permissions2PermissionList(permissions)
    bindings.Permissions.remove(PermissionList(api, host), js.Any.fromFunction1((result: Boolean) => {
      promise.complete(lastErrorOrValue(result))
    }))
    promise.future
  }

}


