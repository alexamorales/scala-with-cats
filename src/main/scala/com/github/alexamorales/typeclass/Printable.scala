package com.github.alexamorales.typeclass

trait Printable[A] {
  def format(value: A): String
}

object Printable {

  def format[A](value: A)(implicit p: Printable[A]): String =
    p.format(value)

  def print[A](value: A)(implicit p: Printable[A]): Unit =
    println(format(value))

  object Syntax {
    implicit class PrintableOps[A](value: A) {
      def format(implicit p: Printable[A]): String = p.format(value)

      def print(implicit p: Printable[A]): Unit =
        println(p.format(value))
    }
  }

  object Instances {
    implicit val intInstance: Printable[Int] = (value: Int) => value.toString

    implicit val stringInstance: Printable[String] = s => s
  }

  object ShowPrintable {
    import cats.Show
    import cats.instances.int._
    import cats.instances.string._

    val showInt: Show[Int] = Show.apply[Int]
    val showString: Show[String] = Show.apply[String]

    val intAsString: String = showInt.show(23)
    val stringAsString: String = showString.show("23")



  }
}
