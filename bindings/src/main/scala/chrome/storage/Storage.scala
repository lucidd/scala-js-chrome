package chrome.storage

import chrome.ChromeAPI
import chrome.events.EventSource
import chrome.events.EventSourceImplicits._
import chrome.permissions.Permission.API
import chrome.storage.bindings.StorageChange
import chrome.utils.ErrorHandling._
import scala.concurrent.{Promise, Future}
import scala.scalajs.js

object Storage extends ChromeAPI {

  implicit class StorageArea(area: bindings.StorageArea) {

    def get(keys: js.UndefOr[js.Any] = js.undefined)
      : Future[js.Dictionary[js.Any]] = {
      val promise = Promise[js.Dictionary[js.Any]]()
      area.get(keys, (results: js.Dictionary[js.Any]) => {
        promise.complete(lastErrorOrValue(results))
      })
      promise.future
    }

    def getBytesInUse(keys: js.UndefOr[js.Any] = js.undefined): Future[Int] = {
      val promise = Promise[Int]()
      area.getBytesInUse(keys, (result: Int) => {
        promise.complete(lastErrorOrValue(result))
      })
      promise.future
    }

    def set(items: js.Dictionary[js.Any]): Future[Unit] = {
      val promise = Promise[Unit]()
      area.set(items, js.Any.fromFunction0(() => {
        promise.complete(lastErrorOrValue(()))
      }))
      promise.future
    }

    def remove(keys: js.Any): Future[Unit] = {
      val promise = Promise[Unit]()
      area.remove(keys, js.Any.fromFunction0(() => {
        promise.complete(lastErrorOrValue(()))
      }))
      promise.future
    }

    def clear: Future[Unit] = {
      val promise = Promise[Unit]()
      area.clear(js.Any.fromFunction0(() => {
        promise.complete(lastErrorOrValue(()))
      }))
      promise.future
    }
  }

  val requiredPermissions: Set[API] = Set(API.Storage)
  val onChanged: EventSource[(Map[String, StorageChange], String)] =
    bindings.Storage.onChanged

  val sync: StorageArea = bindings.Storage.sync
  val local: StorageArea = bindings.Storage.local
  val managed: StorageArea = bindings.Storage.managed

}
