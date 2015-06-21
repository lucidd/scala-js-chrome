package chrome.wallpaper.bindings

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

class WallpaperDetails extends js.Object {
  val binary: js.UndefOr[js.Any] = js.native
  val url: js.UndefOr[String] = js.native
  val layout: WallpaperLayout = js.native
  val filename: String = js.native
  val thumbnail: js.UndefOr[Boolean] = js.native
}

object WallpaperDetails {
  def apply(filename: String,
            layout: WallpaperLayout,
            binary: js.UndefOr[js.Any] = js.undefined,
            url: js.UndefOr[String] = js.undefined,
            thumbnail: js.UndefOr[Boolean] = js.undefined): WallpaperLayout = {
    js.Dynamic.literal(
      filename = filename,
      layout = layout,
      binary = binary,
      url = url,
      thumbnail = thumbnail
    ).asInstanceOf[WallpaperLayout]
  }
}

@JSName("chrome.wallpaper")
object Wallpaper extends js.Object {

  def setWallpaper(details: WallpaperDetails, callback: js.Function1[js.UndefOr[js.Any], _]): Unit = js.native

}
