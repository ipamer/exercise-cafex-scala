package com.cafex

import com.cafex.model.{Item, Till}
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TillWithChargeSpec extends FlatSpec {

  "When I buy 4 items with hot food, cost" should "be 9.6" in {
    val items = List("Cola", "Coffee", "Cheese Sandwich", "Steak Sandwich")
    assert(Till.purchase(items) == 9.6)
  }

  "When I buy 4 items with cold food, cost" should "be 6.05" in {
    val items = List(Item.COLA, Item.COFFEE, Item.CHEESE_SANDWICH, Item.CHEESE_SANDWICH)
    assert(Till.purchaseItems(items) == 6.05)
  }

  "When I buy 4 items with cold food, food first, cost" should "be 6.05" in {
    val items = List(Item.CHEESE_SANDWICH, Item.CHEESE_SANDWICH, Item.COLA, Item.COFFEE)
    assert(Till.purchaseItems(items) == 6.05)
  }

}
