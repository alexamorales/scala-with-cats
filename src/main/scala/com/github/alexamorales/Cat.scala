package com.github.alexamorales
import com.github.alexamorales.typeclass.Printable

case class Cat(name: String, age: Int, color: String)

object Cat {
  object Instances {
    implicit val catPrintable: Printable[Cat] =
      cat => s"Cat name = ${cat.name}, age = ${cat.age}, color = ${cat.color}"

    import cats.Show
    import cats.instances.int._
    import cats.instances.string._
    import cats.syntax.show._

    implicit val catShow: Show[Cat] = { cat =>
      val name = cat.name.show
      val age = cat.age.show
      val color = cat.color.show

      s"Cat name = $name, age = $age, color = $color"
    }

    import cats.Eq
    import cats.syntax.eq._

    implicit val catEq: Eq[Cat] = Eq.instance[Cat] { (cat1, cat2) =>
      cat1.name === cat2.name &&
      cat1.age === cat2.age &&
      cat1.color === cat2.color
    }
  }

}
