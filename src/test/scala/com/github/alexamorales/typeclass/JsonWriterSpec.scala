package com.github.alexamorales.typeclass
import com.github.alexamorales.typeclass.Json.{JsonNumber, JsonObject, JsonString}
import org.scalatest.{Matchers, WordSpec}

class JsonWriterSpec extends WordSpec with Matchers {
  "JsonWriter should" should {

    import Json.Instances._
    import Json.Syntax._

    "transform person to json" in {

      val expected = JsonObject(
        Map(
        "name" -> JsonString("Person"),
        "email" -> JsonString("person@gmail.com"))
      )

      Person("Person", "person@gmail.com").toJson should be(expected)
    }

    "transform int to json" in {
      val expected = JsonNumber(2)

      2.toJson should be(expected)
    }

  }



}
