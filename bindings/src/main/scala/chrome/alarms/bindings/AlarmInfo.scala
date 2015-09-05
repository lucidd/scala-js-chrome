package chrome.alarms.bindings

import scala.scalajs.js

object AlarmInfo {

  def apply(when: js.UndefOr[Double] = js.undefined,
            delayInMinutes: js.UndefOr[Double] = js.undefined,
            periodInMinutes: js.UndefOr[Double] = js.undefined): AlarmInfo = {
    js.Dynamic.literal(
      when = when,
      delayInMinutes = delayInMinutes,
      periodInMinutes = periodInMinutes
    ).asInstanceOf[AlarmInfo]
  }

}

@js.native
trait AlarmInfo extends js.Object {

  def when: js.UndefOr[Double] = js.native
  def delayInMinutes: js.UndefOr[Double] = js.native
  def periodInMinutes: js.UndefOr[Double] = js.native

}
