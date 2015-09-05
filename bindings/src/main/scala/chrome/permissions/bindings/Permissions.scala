package chrome.permissions.bindings

import chrome.events.bindings.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.{UndefOr, native, undefined}


@js.native
@JSName("chrome.permissions")
object Permissions extends js.Object {

  val onAdded: Event[js.Function1[PermissionList, _]] = native
  val onRemoved: Event[js.Function1[PermissionList, _]] = native

  def getAll(callback: js.Function1[PermissionList, _]): Unit = native

  def contains(permissions: PermissionList, callback: js.Function1[Boolean, _]): Unit = native

  def request(permissions: PermissionList, callback: UndefOr[js.Function1[Boolean, _]] = undefined): Unit = native

  def remove(permissions: PermissionList, callback: UndefOr[js.Function1[Boolean, _]] = undefined): Unit = native

}

@js.native
trait PermissionList extends js.Object {

  var permissions: UndefOr[js.Array[String]] = native
  var origins: UndefOr[js.Array[String]] = native

}

object PermissionList {

  def apply(permissions: UndefOr[js.Array[String]] = undefined,
            origins: UndefOr[js.Array[String]] = undefined): PermissionList = {
    js.Dynamic.literal(
      permissions = permissions,
      origins = origins
    ).asInstanceOf[PermissionList]
  }

}
