package com.github.alexamorales.monoid

trait Monoid[A] extends Semigroup[A] {
  def empty: A
}

trait Semigroup[A] {
  def combine(a: A, b: A): A
}

object Monoid {
  def associativeLaw[A](a: A, b: A, c: A)(implicit m: Monoid[A]): Boolean = {
    m.combine(a, m.combine(b, c)) ==
      m.combine(m.combine(a, b), c)
  }

  def identityLaw[A](a: A)(implicit m: Monoid[A]): Boolean = {
    (m.combine(a, m.empty) == a) &&
    (m.combine(m.empty, a) == a)
  }

  def apply[A](implicit monoid: Monoid[A]): Monoid[A] =
    monoid

}


