package chrome.downloads

import bindings._
import chrome.runtime.Runtime
import chrome.runtime.bindings.Error
import chrome.utils.ErrorHandling.lastErrorOrValue

import scala.concurrent.{Future, Promise}
import scalajs.js
import scalajs.js.JSConverters._

object Downloads {

  def download(options: DownloadOptions): Future[DownloadItem.Id] = {
    val promise = Promise[DownloadItem.Id]()
    bindings.Downloads.download(
      options,
      js.Any.fromFunction1((item: DownloadItem.Id) => {
        promise.complete(lastErrorOrValue(item))
      })
    )
    promise.future
  }

  def pause(id: DownloadItem.Id): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.Downloads.pause(
      id,
      js.Any.fromFunction0(() => {
        promise.complete(lastErrorOrValue(()))
      })
    )
    promise.future
  }

  def resume(id: DownloadItem.Id): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.Downloads.resume(
      id,
      js.Any.fromFunction0(() => {
        promise.complete(lastErrorOrValue(()))
      })
    )
    promise.future
  }

  def cancel(id: DownloadItem.Id): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.Downloads.cancel(
      id,
      js.Any.fromFunction0(() => {
        promise.complete(lastErrorOrValue(()))
      })
    )
    promise.future
  }

  def getFileIcon(id: DownloadItem.Id, options: Option[FileIconOptions] = None): Future[Option[String]] = {
    val promise = Promise[Option[String]]()
    bindings.Downloads.getFileIcon(
      id,
      options.orUndefined,
      js.Any.fromFunction1((url: js.UndefOr[String]) => {
        promise.complete(lastErrorOrValue(url.toOption))
      })
    )
    promise.future

  }

  def open(id: DownloadItem.Id): Unit = bindings.Downloads.open(id)
  def show(id: DownloadItem.Id): Unit = bindings.Downloads.show(id)
  def showDefaultFolder(): Unit = bindings.Downloads.showDefaultFolder()

  def erase(query: Query): Future[List[DownloadItem.Id]] = {
    val promise = Promise[List[DownloadItem.Id]]()
    bindings.Downloads.erase(
      query,
      js.Any.fromFunction1((items: js.Array[DownloadItem.Id]) => {
        promise.complete(lastErrorOrValue(items.toList))
      })
    )
    promise.future
  }

  def search(query: Query): Future[List[DownloadItem]] = {
    val promise = Promise[List[DownloadItem]]()
    bindings.Downloads.search(
      query,
      js.Any.fromFunction1((items: js.Array[DownloadItem]) => {
        promise.complete(lastErrorOrValue(items.toList))
      })
    )
    promise.future
  }

  def removeFile(id: DownloadItem.Id): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.Downloads.removeFile(
      id,
      js.Any.fromFunction0(() => {
        promise.complete(lastErrorOrValue(()))
      })
    )
    promise.future
  }

  def acceptDanger(id: DownloadItem.Id): Future[Unit] = {
    val promise = Promise[Unit]()
    bindings.Downloads.acceptDanger(
      id,
      js.Any.fromFunction0(() => {
        promise.complete(lastErrorOrValue(()))
      })
    )
    promise.future
  }

  def drag(id: DownloadItem.Id): Unit = bindings.Downloads.drag(id)

  def setShelfEnabled(enabled: Boolean): Option[Error] = {
    bindings.Downloads.setShelfEnabled(enabled)
    Runtime.lastError
  }

}
