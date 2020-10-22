package chrome.processes.bindings

import chrome.events.bindings.Event
import chrome.tabs.bindings.Tab

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal("chrome.processes")
object Processes extends js.Object {

  val onUpdated: Event[js.Function1[Map[Process.Id, Process], _]] = js.native

  val onUpdatedWithMemory: Event[js.Function1[Map[Process.Id, Process], _]] =
    js.native
  val onCreated: Event[js.Function1[Process, _]] = js.native
  val onUnresponsive: Event[js.Function1[Process, _]] = js.native

  val onExited: Event[js.Function3[Process.Id, Process.ExitType, js.UndefOr[Int], _]] =
    js.native

  def terminate(processId: Process.Id, callback: js.UndefOr[js.Function1[Boolean, _]] = js.undefined): Unit =
    js.native

  def getProcessIdForTab(tabId: Tab.Id, callback: js.Function1[Process.Id, _]): Unit =
    js.native

  def getProcessInfo(
      processIds: js.Array[Process.Id],
      includeMemory: Boolean,
      callback: js.Function1[Map[Process.Id, Process], _]
  ): Unit = js.native

}
