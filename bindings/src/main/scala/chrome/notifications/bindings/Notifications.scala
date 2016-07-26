package chrome.notifications.bindings

import chrome.events.bindings.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
@JSName("chrome.notifications")
object Notifications extends js.Object {

  type Id = String

  val onClose: Event[js.Function2[Id, Boolean, _]] = js.native
  val onClicked: Event[js.Function1[Id, _]] = js.native
  val onButtonClicked: Event[js.Function2[Id, Int, _]] = js.native
  val onPermissionLevelChanged: Event[js.Function1[PermissionLevel, _]] =
    js.native
  val onShowSettings: Event[js.Function0[_]] = js.native

  def create(id: js.UndefOr[Id] = js.undefined,
             options: NotificationOptions,
             callback: js.UndefOr[js.Function1[Id, _]] = js.undefined): Unit =
    js.native

  def update(
      id: Id,
      options: NotificationOptions,
      callback: js.UndefOr[js.Function1[Boolean, _]] = js.undefined): Unit =
    js.native

  def clear(
      id: Id,
      callback: js.UndefOr[js.Function1[Boolean, _]] = js.undefined): Unit =
    js.native

  def getAll(callback: js.Function1[Map[Id, Boolean], _]): Unit = js.native

  def getPermissionLevel(callback: js.Function1[PermissionLevel, _]): Unit =
    js.native

}
