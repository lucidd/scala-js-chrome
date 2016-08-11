package chrome.downloads.bindings

sealed trait DangerType
object DangerType {
  val file: DangerType = "file".asInstanceOf[DangerType]
  val url: DangerType = "url".asInstanceOf[DangerType]
  val content: DangerType = "content".asInstanceOf[DangerType]
  val uncommon: DangerType = "uncommon".asInstanceOf[DangerType]
  val host: DangerType = "host".asInstanceOf[DangerType]
  val unwanted: DangerType = "unwanted".asInstanceOf[DangerType]
  val safe: DangerType = "safe".asInstanceOf[DangerType]
  val accepted: DangerType = "accepted".asInstanceOf[DangerType]
}
