package com.github.alexamorales.functor

sealed trait Tree[+A]

object Tree {
  final case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]
  final case class Leaf[A](value: A) extends Tree[A]

  def branch[A](left: Tree[A], right: Tree[A]):Tree[A] = Branch(left, right)

  def leaf[A](value: A): Tree[A] = Leaf(value)

  object Instances {
    implicit val treeFunctor: cats.Functor[Tree] =
      new cats.Functor[Tree] {
        override def map[A, B](tree: Tree[A])(func: A => B): Tree[B] =
          tree match {
            case Branch(left, right) =>
              Branch(map(left)(func), map(right)(func))
            case Leaf(value) =>
              Leaf(func(value))
          }
      }
  }
}
