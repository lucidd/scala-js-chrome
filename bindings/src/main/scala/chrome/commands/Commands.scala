package chrome.commands

import chrome.commands.bindings.Command
import chrome.events.{EventSource, EventSource1Impl}
import chrome.utils.ErrorHandling._

import scala.concurrent.{Future, Promise}
import scala.scalajs.js

object Commands {

  val onCommand: EventSource[String] = new EventSource1Impl(bindings.Commands.onCommand)

  def getAll: Future[List[Command]] = {
    val promise = Promise[List[Command]]()
    bindings.Commands.getAll(js.Any.fromFunction1((commands: js.Array[Command]) => {
      promise.complete(lastErrorOrValue(commands.toList))
    }))
    promise.future
  }

}
