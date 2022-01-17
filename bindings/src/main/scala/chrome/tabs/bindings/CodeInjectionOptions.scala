package chrome.tabs.bindings

import scala.scalajs.js
import scala.scalajs.js.|.undefOr2jsAny

object CodeInjectionOptions {

  type ExeutionTime = String

  val DOCUMENT_START: ExeutionTime = "document_start"
  val DOCUMENT_END: ExeutionTime = "document_end"
  val DOCUMENT_IDLE: ExeutionTime = "document_idle"

  def apply(
      code: js.UndefOr[String] = js.undefined,
      file: js.UndefOr[String] = js.undefined,
      allFrames: js.UndefOr[Boolean] = js.undefined,
      matchAboutBlank: js.UndefOr[Boolean] = js.undefined,
      runAt: js.UndefOr[String] = js.undefined
  ): CodeInjectionOptions = {
    js.Dynamic
      .literal(
        code = code,
        file = file,
        allFrames = allFrames,
        matchAboutBlank = matchAboutBlank,
        runAt = runAt
      )
      .asInstanceOf[CodeInjectionOptions]
  }

}

@js.native
trait CodeInjectionOptions extends js.Object {

  def code: js.UndefOr[String] = js.native

  def file: js.UndefOr[String] = js.native

  def allFrames: js.UndefOr[Boolean] = js.native

  def matchAboutBlank: js.UndefOr[Boolean] = js.native

  def runAt: js.UndefOr[String] = js.native

}
