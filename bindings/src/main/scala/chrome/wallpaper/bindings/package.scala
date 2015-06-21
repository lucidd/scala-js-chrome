package chrome.wallpaper

package object bindings {

  type WallpaperLayout = String

  object WallpaperLayout {
    val STRETCH: WallpaperLayout = "STRETCH"
    val CENTER: WallpaperLayout = "CENTER"
    val CENTER_CROPPED: WallpaperLayout = "CENTER_CROPPED"
  }

}
