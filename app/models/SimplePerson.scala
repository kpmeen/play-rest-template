package models

import play.api.libs.json.{Format, Json}

case class SimplePerson(name: String, age: Int)

object SimplePerson {
  implicit val format: Format[SimplePerson] = Json.format[SimplePerson]
}
