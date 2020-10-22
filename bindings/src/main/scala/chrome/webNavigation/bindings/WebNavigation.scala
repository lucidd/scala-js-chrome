package chrome.webNavigation.bindings

import chrome.events.bindings.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.native

/**
 * @see <a href="https://developer.chrome.com/extensions/webNavigation">chrome.webNavigation API</a>
 */
@js.native
@JSGlobal("chrome.webNavigation")
object WebNavigation extends js.Object {

  /**
   * Fired when a navigation is about to occur.
   */
  val onBeforeNavigate: Event[js.Function1[OnBeforeNavigateDetails, _]] = native

  /**
   * Fired when a navigation is committed. The document (and the resources it refers to, such as images and subframes)
   * might still be downloading, but at least part of the document has been received from the server and the browser
   * has decided to switch to the new document.
   */
  val onCommitted: Event[js.Function1[OnCommittedDetails, _]] = native

  /**
   * Fired when the page's DOM is fully constructed, but the referenced resources may not finish loading.
   */
  val onDOMContentLoaded: Event[js.Function1[OnDOMContentLoadedDetails, _]] = native

  /**
   * Fired when a document, including the resources it refers to, is completely loaded and initialized.
   */
  val onCompleted: Event[js.Function1[OnCompletedDetails, _]] = native

  /**
   * Fired when an error occurs and the navigation is aborted. This can happen if either a network error occurred, or
   * the user aborted the navigation.
   */
  val onErrorOccurred: Event[js.Function1[OnErrorOccurredDetails, _]] = native

  /**
   * Fired when a new window, or a new tab in an existing window, is created to host a navigation.
   */
  val onCreatedNavigationTarget: Event[js.Function1[OnCreatedNavigationTargetDetails, _]] = native

  /**
   * Fired when the reference fragment of a frame was updated.
   * All future events for that frame will use the updated URL.
   */
  val onReferenceFragmentUpdated: Event[js.Function1[OnCommittedDetails, _]] = native

  /**
   * Fired when the contents of the tab is replaced by a different (usually previously pre-rendered) tab.
   */
  val onTabReplaced: Event[js.Function1[OnTabReplacedDetails, _]] = native

  /**
   * Fired when the frame's history was updated to a new URL.
   * All future events for that frame will use the updated URL.
   */
  val onHistoryStateUpdated: Event[js.Function1[OnCommittedDetails, _]] = native

  /**
   * Retrieves information about the given frame. A frame refers to an <iframe> or a <frame> of a web page and is
   * identified by a tab ID and a frame ID.
   *
   * @param details Information about the frame to retrieve information about.
   * @param callback Information about the requested frame, null if the specified frame ID and/or tab ID are invalid.
   */
  def getFrame(details: GetFrameOptions, callback: js.Function1[FrameDetails, _]): Unit = native

  /**
   * Retrieves information about all frames of a given tab.
   *
   * @param details Information about the tab to retrieve all frames from.
   * @param callback A list of frames in the given tab, null if the specified tab ID is invalid.
   */
  def getAllFrames(details: GetAllFramesOptions, callback: js.Function1[js.Array[AllFramesDetails], _]): Unit = native
}
