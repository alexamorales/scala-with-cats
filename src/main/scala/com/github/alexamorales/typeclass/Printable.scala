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
    val intInstance: Printable[Int] = (value: Int) => value.toString

    val stringInstance: Printable[String] = s => s
  }
}
