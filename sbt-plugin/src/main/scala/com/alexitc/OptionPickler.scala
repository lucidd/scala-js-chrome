package com.alexitc

object OptionPickler extends upickle.AttributeTagged {

  override implicit def OptionWriter[T: Writer]: Writer[Option[T]] =
    implicitly[Writer[T]].comap[Option[T]] {
      case None => null.asInstanceOf[T]
      case Some(x) => x
    }

  override implicit def OptionReader[T: Reader]: Reader[Option[T]] =
    implicitly[Reader[T]].mapNulls {
      case null => None
      case x => Some(x)
    }

  implicit def rwStrMap[T: ReadWriter]: ReadWriter[Map[String, T]] =
    readwriter[ujson.Obj].bimap[Map[String, T]](
      obj => {
        obj.toSeq.map(x => (x._1, writeJs[T](x._2)))
      },
      json => json.value.map(x => (x._1, read[T](x._2))).toMap
    )

  implicit def rwIntMap[T: ReadWriter]: ReadWriter[Map[Int, T]] =
    readwriter[ujson.Obj].bimap[Map[Int, T]](
      obj => {
        obj.toSeq.map(x => (x._1.toString, writeJs[T](x._2)))
      },
      json => json.value.map(x => (x._1.toInt, read[T](x._2))).toMap
    )
}
