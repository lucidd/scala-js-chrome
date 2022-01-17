package chrome.permissions.bindings

import chrome.events.bindings.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.{UndefOr, undefined}
import scala.scalajs.js.|.undefOr2jsAny

@js.native
@JSGlobal("chrome.permissions")
object Permissions extends js.Object {

  val onAdded: Event[js.Function1[PermissionList, _]] = js.native
  val onRemoved: Event[js.Function1[PermissionList, _]] = js.native

  def getAll(callback: js.Function1[PermissionList, _]): Unit = js.native

  def contains(permissions: PermissionList, callback: js.Function1[Boolean, _]): Unit = js.native

  def request(permissions: PermissionList, callback: UndefOr[js.Function1[Boolean, _]] = undefined): Unit =
    js.native

  def remove(permissions: PermissionList, callback: UndefOr[js.Function1[Boolean, _]] = undefined): Unit =
    js.native

}

@js.native
trait PermissionList extends js.Object {

  var permissions: UndefOr[js.Array[String]] = js.native
  var origins: UndefOr[js.Array[String]] = js.native

}

object PermissionList {

  def apply(
      permissions: UndefOr[js.Array[String]] = undefined,
      origins: UndefOr[js.Array[String]] = undefined
  ): PermissionList = {
    js.Dynamic
      .literal(
        permissions = permissions,
        origins = origins
      )
      .asInstanceOf[PermissionList]
  }

}
