package chrome.storage.bindings

import chrome.events.bindings.Event

import scala.scalajs.js.annotation.JSName
import scala.scalajs.js

class StorageChange extends js.Object {

  val oldValue: js.UndefOr[js.Any] = js.native
  val newValue: js.UndefOr[js.Any] = js.native

}

class StorageArea extends js.Object {

  def get(keys: js.UndefOr[js.Any] = js.undefined, callback: js.Function1[Map[String, js.Any], _]): Unit = js.native
  def getBytesInUse(keys: js.UndefOr[js.Any] = js.undefined, callback: js.Function1[Int, _]): Unit = js.native
  def set(items: Map[String, js.Any], callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native
  def remove(keys: js.Any, callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native
  def clear(callback: js.UndefOr[js.Function0[_]] = js.undefined): Unit = js.native

}

@JSName("chrome.storage")
object Storage extends js.Object {

  val onChanged: Event[js.Function2[Map[String, StorageChange], String, _]] = js.native

  val sync: StorageArea = js.native
  val local: StorageArea = js.native
  val managed: StorageArea = js.native

}
