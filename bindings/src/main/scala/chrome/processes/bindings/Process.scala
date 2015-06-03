package chrome.processes.bindings

import chrome.tabs.bindings.Tab

import scala.scalajs.js

class Process extends js.Object {

  val id: Process.Id = js.native
  val osProcessId: Process.Id = js.native
  val title: String = js.native
  val `type`: Process.Type = js.native
  val profile: String  = js.native
  val naclDebugPort: Int = js.native
  val tabs: js.Array[Tab.Id] = js.native
  val cpu: js.UndefOr[Double] = js.native
  val network: js.UndefOr[Double] = js.native
  val privateMemory: js.UndefOr[Double] = js.native
  val jsMemoryAllocated: js.UndefOr[Double] = js.native
  val jsMemoryUsed: js.UndefOr[Double] = js.native
  val sqliteMemory: js.UndefOr[Double] = js.native
  val imageCache: js.UndefOr[Cache] = js.native
  val scriptCache: js.UndefOr[Cache] = js.native
  val cssCache: js.UndefOr[Cache] = js.native


}

object Process {
  type Id = Int
  type Type = String
  type ExitType = Int

  object ExitType {
    //TODO: find out the values of these
    val NORMAL: ExitType = ???
    val ABNORMAL: ExitType = ???
    val KILLED: ExitType = ???
    val CRASHED: ExitType = ???
  }

  object Type {
    val BROWSER: Type = "browser"
    val RENDERER: Type = "renderer"
    val EXTENTION: Type = "extension"
    val NOTIFICATION: Type = "notification"
    val PLUGIN: Type = "plugin"
    val WORKER: Type = "worker"
    val NACL: Type = "nacl"
    val UTILITY: Type = "utility"
    val GPU: Type = "gpu"
    val OTHER: Type = "other"
  }
}
