package chrome.webNavigation

import chrome.ChromeAPI
import chrome.events.EventSource
import chrome.events.EventSourceImplicits._
import chrome.permissions.Permission.API
import chrome.utils.ErrorHandling.lastErrorOrValue
import chrome.webNavigation.bindings._

import scala.concurrent.{Future, Promise}
import scala.scalajs.js
import scala.collection.mutable.Seq

/**
  * @see <a href="https://developer.chrome.com/extensions/webNavigation">chrome.webNavigation API</a>
  */
object WebNavigation extends ChromeAPI {
  override val requiredPermissions: Set[API] = Set(API.WebNavigation)

  /**
    * Fired when a navigation is about to occur.
    */
  val onBeforeNavigate: EventSource[OnBeforeNavigateDetails] = bindings.WebNavigation.onBeforeNavigate
  /**
    * Fired when a navigation is committed. The document (and the resources it refers to, such as images and subframes)
    * might still be downloading, but at least part of the document has been received from the server and the browser
    * has decided to switch to the new document.
    */
  val onCommitted: EventSource[OnCommittedDetails] = bindings.WebNavigation.onCommitted
  /**
    * Fired when the page's DOM is fully constructed, but the referenced resources may not finish loading.
    */
  val onDOMContentLoaded: EventSource[OnDOMContentLoadedDetails] = bindings.WebNavigation.onDOMContentLoaded
  /**
    * Fired when a document, including the resources it refers to, is completely loaded and initialized.
    */
  val onCompleted: EventSource[OnCompletedDetails] = bindings.WebNavigation.onCompleted
  /**
    * Fired when an error occurs and the navigation is aborted. This can happen if either a network error occurred, or
    * the user aborted the navigation.
    */
  val onErrorOccurred: EventSource[OnErrorOccurredDetails] = bindings.WebNavigation.onErrorOccurred
  /**
    * Fired when a new window, or a new tab in an existing window, is created to host a navigation.
    */
  val onCreatedNavigationTarget: EventSource[OnCreatedNavigationTargetDetails] =
    bindings.WebNavigation.onCreatedNavigationTarget
  /**
    * Fired when the reference fragment of a frame was updated.
    * All future events for that frame will use the updated URL.
    */
  val onReferenceFragmentUpdated: EventSource[OnCommittedDetails] = bindings.WebNavigation.onReferenceFragmentUpdated
  /**
    * Fired when the contents of the tab is replaced by a different (usually previously pre-rendered) tab.
    */
  val onTabReplaced: EventSource[OnTabReplacedDetails] = bindings.WebNavigation.onTabReplaced
  /**
    * Fired when the frame's history was updated to a new URL.
    * All future events for that frame will use the updated URL.
    */
  val onHistoryStateUpdated: EventSource[OnCommittedDetails] = bindings.WebNavigation.onHistoryStateUpdated

  /**
    * Retrieves information about the given frame. A frame refers to an <iframe> or a <frame> of a web page and is
    * identified by a tab ID and a frame ID.
    *
    * @param details Information about the frame to retrieve information about.
    */
  def getFrame(details: GetFrameOptions): Future[FrameDetails] = {
    val promise = Promise[FrameDetails]
    bindings.WebNavigation.getFrame(details, (frameDetails: FrameDetails) =>
      promise.complete(lastErrorOrValue(frameDetails))
    )
    promise.future
  }

  /**
    * Retrieves information about all frames of a given tab.
    *
    * @param details Information about the tab to retrieve all frames from.
    */
  def getAllFrames(details: GetAllFramesOptions): Future[Seq[AllFramesDetails]] = {
    val promise = Promise[Seq[AllFramesDetails]]
    bindings.WebNavigation.getAllFrames(details, (allFrames: js.Array[AllFramesDetails]) =>
      promise.complete(lastErrorOrValue(allFrames))
    )
    promise.future
  }
}
