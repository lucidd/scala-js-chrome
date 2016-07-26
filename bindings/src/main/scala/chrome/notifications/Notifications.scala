package chrome.notifications

import bindings._
import bindings.Notifications.Id
import chrome.ChromeAPI
import chrome.events.EventSource
import chrome.events.EventSourceImplicits._
import chrome.utils.ErrorHandling._
import chrome.permissions.Permission.API
import scala.scalajs.js
import scala.scalajs.js.JSConverters._

import scala.concurrent.{Promise, Future}

object Notifications extends ChromeAPI {

  val requiredPermissions: Set[API] = Set(API.Notifications)

  val onClose: EventSource[(Id, Boolean)] = bindings.Notifications.onClose
  val onClicked: EventSource[Id] = bindings.Notifications.onClicked
  val onButtonClicked: EventSource[(Id, Int)] =
    bindings.Notifications.onButtonClicked
  val onPermissionLevelChanged: EventSource[PermissionLevel] =
    bindings.Notifications.onPermissionLevelChanged
  val onShowSettings: EventSource[Unit] = bindings.Notifications.onShowSettings

  def create(options: NotificationOptions, id: Option[Id] = None): Future[Id] = {
    val promise = Promise[Id]()
    bindings.Notifications
      .create(id.orUndefined, options, js.Any.fromFunction1((id: Id) => {
        promise.complete(lastErrorOrValue(id))
      }))
    promise.future
  }

  def update(id: Id, options: NotificationOptions): Future[Boolean] = {
    val promise = Promise[Boolean]()
    bindings.Notifications
      .update(id, options, js.Any.fromFunction1((wasUpdated: Boolean) => {
        promise.complete(lastErrorOrValue(wasUpdated))
      }))
    promise.future
  }

  def clear(id: Id): Future[Boolean] = {
    val promise = Promise[Boolean]()
    bindings.Notifications
      .clear(id, js.Any.fromFunction1((wasCleared: Boolean) => {
        promise.complete(lastErrorOrValue(wasCleared))
      }))
    promise.future
  }

  def getAll: Future[Map[Id, Boolean]] = {
    val promise = Promise[Map[Id, Boolean]]()
    bindings.Notifications.getAll((result: Map[Id, Boolean]) => {
      promise.complete(lastErrorOrValue(result))
    })
    promise.future
  }

  def getPermissionLevel: Future[PermissionLevel] = {
    val promise = Promise[PermissionLevel]()
    bindings.Notifications.getPermissionLevel((permLevel: PermissionLevel) => {
      promise.complete(lastErrorOrValue(permLevel))
    })
    promise.future
  }

}
