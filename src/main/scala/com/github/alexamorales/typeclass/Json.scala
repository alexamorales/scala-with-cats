package com.github.alexamorales.typeclass

sealed trait Json

object Json {

  final case class JsonObject(value: Map[String, Json]) extends Json
  final case class JsonString(value: String) extends Json
  final case class JsonNumber(value: Double) extends Json
  case object JsNull extends Json

  // The "serialize to JSON" behaviour is encoded in this trait
  trait JsonWriter[A] {
    def write(value: A): Json
  }

  object Syntax {
    implicit class JsonWriterOps[A](value: A) {
      def toJson(implicit w: JsonWriter[A]): Json =
        w.write(value)
    }
  }

  object Instances {

    implicit val stringWriter: JsonWriter[String] =
      new JsonWriter[String] {
        def write(value: String): Json =
          JsonString(value)
      }

    implicit val personWriter: JsonWriter[Person] =
      new JsonWriter[Person] {
        def write(value: Person): Json =
          JsonObject(
            Map(
              "name" -> JsonString(value.name),
              "email" -> JsonString(value.email)
            )
          )
      }

    implicit val numberWriter: JsonWriter[Int] =
      new JsonWriter[Int] {
        override def write(value: Int): Json =
          JsonNumber(value)
      }

    final case class Person(name: String, email: String)
  }
}
