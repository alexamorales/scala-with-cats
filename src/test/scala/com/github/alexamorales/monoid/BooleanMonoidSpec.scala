package com.github.alexamorales.monoid
import org.scalatest.{Matchers, WordSpec}

class BooleanMonoidSpec extends WordSpec with Matchers {

  case class Case(monoid: Monoid[Boolean], name: String)
  import BooleanMonoid.BooleanInstances._

  val cases: Seq[Case] = Seq(
    Case(booleanAndMonoid, "And"),
    Case(booleanOrMonoid, "Or"),
    Case(booleanEitherMonoid, "Either"),
    Case(booleanXnorMonoid, "Xnor")
  )


      for (Case(monoid, name) <- cases) {
        s"boolean $name monoid" should {
          implicit val m: Monoid[Boolean] = monoid

          "respect associativity" in {
            assert(Monoid.associativeLaw(true, true, true))
          }
        }
      }
}
