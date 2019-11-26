package com.cafex

import com.cafex.model.{Item, ItemType, Temperature}
import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ItemsSpec extends FunSpec {

  describe("An Item of") {

    describe("Cola") {
      it("should deserialize") {
        assert(Item("Cola").get == Item.COLA)
      }
      it("should be cold") {
        assert(Item.COLA.temperature == Temperature.COLD)
      }
      it("should be drink") {
        assert(Item.COLA.itemType == ItemType.DRINK)
      }
      it("should cost 50p") {
        assert(Item.COLA.price == 0.50)
      }
    }

    describe("Coffee") {
      it("should deserialize") {
        assert(Item("Coffee").get == Item.COFFEE)
      }
      it("should be hot") {
        assert(Item.COFFEE.temperature == Temperature.HOT)
      }
      it("should be drink") {
        assert(Item.COFFEE.itemType == ItemType.DRINK)
      }
      it("should cost 1.00") {
        assert(Item.COFFEE.price == 1.00)
      }
    }

    describe("Cheese Sandwich") {
      it("should deserialize") {
        assert(Item("Cheese Sandwich").get == Item.CHEESE_SANDWICH)
      }
      it("should be cold") {
        assert(Item.CHEESE_SANDWICH.temperature == Temperature.COLD)
      }
      it("should be food") {
        assert(Item.CHEESE_SANDWICH.itemType == ItemType.FOOD)
      }
      it("should cost 2.00") {
        assert(Item.CHEESE_SANDWICH.price == 2.00)
      }
    }

    describe("Steak Sandwich") {
      it("should deserialize") {
        assert(Item("Steak Sandwich").get == Item.STEAK_SANDWICH)
      }
      it("should be hot") {
        assert(Item.STEAK_SANDWICH.temperature == Temperature.HOT)
      }
      it("should be food") {
        assert(Item.STEAK_SANDWICH.itemType == ItemType.FOOD)
      }
      it("should cost 4.50") {
        assert(Item.STEAK_SANDWICH.price == 4.50)
      }
    }

  }

}
