package chrome.management

import chrome.ChromeAPI
import chrome.events.EventSource
import chrome.events.EventSourceImplicits._
import chrome.management.bindings.ExtensionInfo._
import chrome.management.bindings._
import chrome.permissions.APIPermission
import chrome.runtime.bindings.Runtime.AppID
import chrome.utils.ErrorHandling._

import scala.concurrent.{Future, Promise}
import scala.scalajs.js

object Management extends ChromeAPI {

  val requiredPermissions: Set[APIPermission] = Set(APIPermission.Management)

  val onInstalled: EventSource[ExtensionInfo] = bindings.Management.onInstalled
  val onUninstalled: EventSource[String] = bindings.Management.onUninstalled
  val onEnabled: EventSource[ExtensionInfo] = bindings.Management.onEnabled
  val onDisabled: EventSource[ExtensionInfo] = bindings.Management.onDisabled

  def getAll: Future[js.Array[ExtensionInfo]] = {
    val promise = Promise[js.Array[ExtensionInfo]]()
    bindings.Management.getAll((extensions: js.Array[ExtensionInfo]) => {
      promise.complete(lastErrorOrValue(extensions))
    })
    promise.future
  }

  def get(id: AppID): Future[ExtensionInfo] = {
    val promise = Promise[ExtensionInfo]()
    bindings.Management.get(id, (extension: ExtensionInfo) => {
      promise.complete(lastErrorOrValue(extension))
    })
    promise.future
  }

  def getSelf: Future[ExtensionInfo] = {
    val promise = Promise[ExtensionInfo]()
    bindings.Management.getSelf((self: ExtensionInfo) => {
      promise.complete(lastErrorOrValue(self))
    })
    promise.future
  }

  def getPermissionWarningsById(id: AppID): Future[js.Array[String]] = {
    val promise = Promise[js.Array[String]]()
    bindings.Management
      .getPermissionWarningsById(id, (warnings: js.Array[String]) => {
        promise.complete(lastErrorOrValue(warnings))
      })
    promise.future
  }

  def getPermissionWarningsByManifest(
      manifestStr: String): Future[js.Array[String]] = {
    val promise = Promise[js.Array[String]]()
    bindings.Management.getPermissionWarningsByManifest(
        manifestStr,
        (warnings: js.Array[String]) => {
          promise.complete(lastErrorOrValue(warnings))
        })
    promise.future
  }

  def setEnabled(id: AppID, enabled: Boolean): Future[Boolean] = {
    val promise = Promise[Boolean]()
    bindings.Management.setEnabled(id, enabled, js.Any.fromFunction0(() => {
      promise.complete(lastErrorOrValue(enabled))
    }))
    promise.future
  }

  def uninstall(
      id: AppID,
      options: js.UndefOr[js.Object] = js.undefined): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.Management.uninstall(id, options, js.Any.fromFunction0(() => {
      promise.complete(lastErrorOrValue(()))
    }))
    promise.future
  }

  def uninstallSelf(
      options: js.UndefOr[js.Object] = js.undefined,
      callback: js.UndefOr[js.Function0[_]] = js.undefined): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.Management.uninstallSelf(options, js.Any.fromFunction0(() => {
      promise.complete(lastErrorOrValue(()))
    }))
    promise.future
  }

  def launchApp(id: AppID): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.Management.launchApp(id, js.Any.fromFunction0(() => {
      promise.complete(lastErrorOrValue(()))
    }))
    promise.future
  }

  def createAppShortcut(id: AppID): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.Management.createAppShortcut(id, js.Any.fromFunction0(() => {
      promise.complete(lastErrorOrValue(()))
    }))
    promise.future
  }

  def setLaunchType(id: AppID, launchType: LaunchType): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.Management
      .setLaunchType(id, launchType, js.Any.fromFunction0(() => {
        promise.complete(lastErrorOrValue(()))
      }))
    promise.future
  }

  def generateAppForLink(url: String, title: String): Future[ExtensionInfo] = {
    val promise = Promise[ExtensionInfo]()
    bindings.Management.generateAppForLink(
        url,
        title,
        js.Any.fromFunction1((info: ExtensionInfo) => {
          promise.complete(lastErrorOrValue(info))
        }))
    promise.future
  }

}
