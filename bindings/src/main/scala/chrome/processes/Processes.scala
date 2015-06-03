package chrome.processes

import chrome.events.EventSource
import chrome.events.EventSourceImplicits._
import chrome.processes.bindings._
import chrome.tabs.bindings.Tab

import scala.concurrent.{Future, Promise}
import scala.scalajs.js

object Processes {

  val onUpdated: EventSource[Map[Process.Id, Process]] = bindings.Processes.onUpdated
  val onUpdatedWithMemory: EventSource[Map[Process.Id, Process]] = bindings.Processes.onUpdatedWithMemory
  val onCreated: EventSource[Process] = bindings.Processes.onCreated
  val onUnresponsive: EventSource[Process] = bindings.Processes.onUnresponsive
  val onExited: EventSource[(Process.Id, Process.ExitType, js.UndefOr[Int])] = bindings.Processes.onExited

  def terminate(processId: Process.Id): Future[Boolean] = {
    val promise = Promise[Boolean]()
    bindings.Processes.terminate(processId, js.Any.fromFunction1((terminated: Boolean) => {
      promise.complete(chrome.lastErrorOrValue(terminated))
    }))
    promise.future
  }

  def getProcessIdForTab(tabId: Tab.Id): Future[Process.Id] = {
    val promise = Promise[Process.Id]()
    bindings.Processes.getProcessIdForTab(tabId, (pid: Process.Id) => {
      promise.complete(chrome.lastErrorOrValue(pid))
    })
    promise.future
  }

  def getProcessInfo(processIds: js.Array[Process.Id], includeMemory: Boolean): Future[Map[Process.Id, Process]] = {
    val promise = Promise[Map[Process.Id, Process]]()
    bindings.Processes.getProcessInfo(processIds, includeMemory, (info: Map[Process.Id, Process]) => {
      promise.complete(chrome.lastErrorOrValue(info))
    })
    promise.future
  }

}
