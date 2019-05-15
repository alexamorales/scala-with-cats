package com.github.alexamorales.monoid

object SetSemigroupsAndMonoid {

  def setUnionMonoid[A](): Monoid[Set[A]] =
    new Monoid[Set[A]] {
      override def combine(a: Set[A], b: Set[A]): Set[A] = a union b
      override def empty: Set[A] = Set.empty
    }

  def setIntersectionMonoid[A](): Semigroup[Set[A]] =
    new Semigroup[Set[A]] {
      override def combine(a: Set[A], b: Set[A]): Set[A] = a intersect b
    }

  def symmetricDifference[A](): Monoid[Set[A]] =
    new Monoid[Set[A]] {
      override def combine(a: Set[A], b: Set[A]): Set[A] =
        (a diff b) union (b diff a)
      override def empty: Set[A] = Set.empty
    }

}
