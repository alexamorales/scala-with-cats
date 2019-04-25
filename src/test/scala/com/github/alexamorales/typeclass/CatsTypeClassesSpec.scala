package com.github.alexamorales.typeclass
import com.github.alexamorales.Cat
import org.scalatest.{Matchers, WordSpec}

class CatsTypeClassesSpec extends WordSpec with Matchers {

  "Show" should {
      "apply Show to Cat instance" in {

        import cats.syntax.show._
        import Cat.Instances._

        val expected = "Cat name = Rob, age = 25, color = white"

        Cat("Rob", 25, "white").show should be(expected)
      }

      "comapre two unequal cats" in {

        import cats.syntax.eq._
        import Cat.Instances._

        val cat1 = Cat("Garfield", 38, "orange and black")
        val cat2 = Cat("Heathcliff", 32, "orange and black")

        cat1 =!= cat2 should be(true)
      }

    "compare two equal cats" in {
      import cats.syntax.eq._
      import Cat.Instances._

      val cat1 = Cat("Garfield", 38, "orange and black")
      val cat2 = Cat("Garfield", 38, "orange and black")

      cat1 =!= cat2 should be(false)

    }

    "compare two equal cats wrapped in optional" in {
      import cats.instances.option._
      import cats.syntax.option._
      import Cat.Instances._
      import cats.syntax.eq._


      val optionCat1 = Cat("Garfield", 38, "orange and black").some
      val optionCat2 = Cat("Garfield", 38, "orange and black").some

      optionCat1 =!= optionCat2 should be(false)
    }



    }
  }
