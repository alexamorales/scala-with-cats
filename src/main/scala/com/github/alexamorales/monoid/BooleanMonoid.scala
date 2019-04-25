package com.github.alexamorales.monoid

object BooleanMonoid {

  object BooleanInstances {

     val booleanAndMonoid: Monoid[Boolean] = new Monoid[Boolean] {
      override def empty: Boolean = true
      override def combine(a: Boolean, b: Boolean): Boolean = a && b
    }

     val booleanOrMonoid: Monoid[Boolean] = new Monoid[Boolean] {
      override def empty: Boolean = false
      override def combine(a: Boolean, b: Boolean): Boolean = a || b
    }

     val booleanEitherMonoid: Monoid[Boolean] = new Monoid[Boolean] {
      override def empty: Boolean = false
      override def combine(a: Boolean, b: Boolean): Boolean =
        (a && !b) || (!a && b)
    }

     val booleanXnorMonoid: Monoid[Boolean] = new Monoid[Boolean] {
      override def empty: Boolean = true
      override def combine(a: Boolean, b: Boolean): Boolean =
        (!a || b) && (a || !b)
    }



  }

}
