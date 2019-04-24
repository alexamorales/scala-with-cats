package com.github.alexamorales.typeclass
import com.github.alexamorales.Cat
import org.scalatest.{Matchers, WordSpec}

class PrintableSpec extends WordSpec with Matchers {
  "A Printable" should {

    "be applied to String value" in {
      import Printable.Instances._
      Printable.format("Scala with Cats")(stringInstance) shouldBe "Scala with Cats"
    }

    "be applied to Cats object" in {
      import com.github.alexamorales.Cat.Instances._
      import Printable.Syntax._

      Cat("Alex", 28, "green").format should be("Cat name = Alex, age = 28, color = green")
    }
  }


}
