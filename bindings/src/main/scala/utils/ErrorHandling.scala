package utils

import chrome.runtime.bindings.Runtime

import scala.util.{Failure, Success, Try}

object ErrorHandling {

  def lastErrorOrValue[T](value: => T): Try[T] = {
    Runtime.lastError.map {
      x => Failure(new Exception(x.message.getOrElse("")))
    }.getOrElse(Success(value))
  }

}
