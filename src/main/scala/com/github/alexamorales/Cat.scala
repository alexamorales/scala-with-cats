package com.github.alexamorales
import com.github.alexamorales.typeclass.Printable

case class Cat(name: String, age: Int, color: String)

object Cat {
  object Instances {
    implicit val catPrintable: Printable[Cat] =
      cat => s"Cat name = ${cat.name}, age = ${cat.age}, color = ${cat.color}"
  }

}
