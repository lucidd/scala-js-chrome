package chrome.management

import chrome.events.bindings.Event
import chrome.management.bindings.ExtensionInfo._

import scala.concurrent.{Promise, Future}
import scala.scalajs.js
import bindings._

object Management {

  def getAll: Future[js.Array[ExtensionInfo]] = {
    val promise = Promise[js.Array[ExtensionInfo]]
    bindings.Management.getAll((extensions: js.Array[ExtensionInfo]) => {
      promise.complete(chrome.lastErrorOrValue(extensions))
    })
    promise.future
  }
  
  def get(id: String): Future[ExtensionInfo] = {
    val promise = Promise[ExtensionInfo]
    bindings.Management.get(id, (extension: ExtensionInfo) => {
      promise.complete(chrome.lastErrorOrValue(extension))
    })
    promise.future
  }
  
  def getSelf: Future[ExtensionInfo] = {
    val promise = Promise[ExtensionInfo]
    bindings.Management.getSelf((self: ExtensionInfo) => {
      promise.complete(chrome.lastErrorOrValue(self))
    })
    promise.future
  }
  
  def getPermissionWarningsById(id: String): Future[js.Array[String]] = {
    val promise = Promise[js.Array[String]]
    bindings.Management.getPermissionWarningsById(id, (warnings: js.Array[String]) => {
      promise.complete(chrome.lastErrorOrValue(warnings))
    })
    promise.future
  }
  
  
  def getPermissionWarningsByManifest(manifestStr: String): Future[js.Array[String]] = {
    val promise = Promise[js.Array[String]]
    bindings.Management.getPermissionWarningsByManifest(manifestStr, (warnings: js.Array[String]) => {
      promise.complete(chrome.lastErrorOrValue(warnings))
    })
    promise.future
  }
  
  
  def setEnabled(id: String, enabled: Boolean): Future[Boolean] = {
    val promise = Promise[Boolean]
    bindings.Management.setEnabled(id, enabled, js.Any.fromFunction0(() => {
      promise.complete(chrome.lastErrorOrValue(enabled))
    }))
    promise.future
  }
  
  
  def uninstall(id: String, options: js.UndefOr[js.Object] = js.undefined): Future[Unit] = {
    val promise = Promise[Unit]
    bindings.Management.uninstall(id, options, js.Any.fromFunction0(() => {
      promise.complete(chrome.lastErrorOrValue(()))
    }))
    promise.future
  }
  
  def uninstallSelf(options: js.UndefOr[js.Object] = js.undefined, callback: js.UndefOr[js.Function0[_]] = js.undefined): Future[Unit] = {
    val promise = Promise[Unit]
    bindings.Management.uninstallSelf(options, js.Any.fromFunction0(() => {
      promise.complete(chrome.lastErrorOrValue(()))
    }))
    promise.future
  }
  
  def launchApp(id: String): Future[Unit] = {
    val promise = Promise[Unit]
    bindings.Management.launchApp(id, js.Any.fromFunction0(() => {
      promise.complete(chrome.lastErrorOrValue(()))
    }))
    promise.future
  }
  
  
  def createAppShortcut(id: String): Future[Unit] = {
    val promise = Promise[Unit]
    bindings.Management.createAppShortcut(id, js.Any.fromFunction0(() => {
      promise.complete(chrome.lastErrorOrValue(()))
    }))
    promise.future
  }
  
  def setLaunchType(id: String, launchType: LaunchType): Future[Unit] = {
    val promise = Promise[Unit]
    bindings.Management.setLaunchType(id, launchType, js.Any.fromFunction0(() => {
      promise.complete(chrome.lastErrorOrValue(()))
    }))
    promise.future
  }
  
  def generateAppForLink(url: String, title: String): Future[ExtensionInfo] = {
    val promise = Promise[ExtensionInfo]
    bindings.Management.generateAppForLink(url, title, js.Any.fromFunction1((info: ExtensionInfo) => {
      promise.complete(chrome.lastErrorOrValue(info))
    }))
    promise.future
  }

  val onInstalled: Event[js.Function1[ExtensionInfo, _]] = bindings.Management.onInstalled
  val onUninstalled: Event[js.Function1[String, _]] = bindings.Management.onUninstalled
  val onEnabled: Event[js.Function1[ExtensionInfo, _]] = bindings.Management.onEnabled
  val onDisabled: Event[js.Function1[ExtensionInfo, _]] = bindings.Management.onDisabled
  
}
