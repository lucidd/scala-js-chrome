package chrome.notifications.bindings

import scala.scalajs.js
import scala.scalajs.js.|.undefOr2jsAny

@js.native
trait NotificationOptions extends js.Object {

  val `type`: js.UndefOr[TemplateType] = js.native
  val iconUrl: js.UndefOr[String] = js.native
  val appIconMaskUrl: js.UndefOr[String] = js.native
  val title: js.UndefOr[String] = js.native
  val message: js.UndefOr[String] = js.native
  val contextMessage: js.UndefOr[String] = js.native
  val priority: js.UndefOr[Int] = js.native
  val eventTime: js.UndefOr[Double] = js.native
  val buttons: js.UndefOr[js.Array[Button]] = js.native
  val imageUrl: js.UndefOr[String] = js.native
  val items: js.UndefOr[js.Array[Item]] = js.native
  val progress: js.UndefOr[Int] = js.native
  val isClickable: js.UndefOr[Boolean] = js.native

}

object NotificationOptions {

  def apply(
      `type`: js.UndefOr[TemplateType] = js.undefined,
      iconUrl: js.UndefOr[String] = js.undefined,
      appIconMaskUrl: js.UndefOr[String] = js.undefined,
      title: js.UndefOr[String] = js.undefined,
      message: js.UndefOr[String] = js.undefined,
      contextMessage: js.UndefOr[String] = js.undefined,
      priority: js.UndefOr[Int] = js.undefined,
      eventTime: js.UndefOr[Double] = js.undefined,
      buttons: js.UndefOr[js.Array[Button]] = js.undefined,
      imageUrl: js.UndefOr[String] = js.undefined,
      items: js.UndefOr[js.Array[Item]] = js.undefined,
      progress: js.UndefOr[Int] = js.undefined,
      isClickable: js.UndefOr[Boolean] = js.undefined
  ): NotificationOptions = {
    js.Dynamic
      .literal(
        `type` = `type`,
        iconUrl = iconUrl,
        appIconMaskUrl = appIconMaskUrl,
        title = title,
        message = message,
        contextMessage = contextMessage,
        priority = priority,
        eventTime = eventTime,
        buttons = buttons,
        imageUrl = imageUrl,
        items = items,
        progress = progress,
        isClickable = isClickable
      )
      .asInstanceOf[NotificationOptions]
  }
}

@js.native
trait Button extends js.Object {
  val title: String = js.native
  val iconUrl: js.UndefOr[String] = js.native
}

object Button {

  def apply(title: String, iconUrl: js.UndefOr[String] = js.undefined): Button = {
    js.Dynamic
      .literal(
        title = title,
        iconUrl = iconUrl
      )
      .asInstanceOf[Button]
  }

}

@js.native
trait Item extends js.Object {
  val title: String = js.native
  val message: String = js.native
}

object Item {

  def apply(title: String, message: String): Item = {
    js.Dynamic
      .literal(
        title = title,
        message = message
      )
      .asInstanceOf[Item]
  }

}
