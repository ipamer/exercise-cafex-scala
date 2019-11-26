package com.cafex

import com.cafex.model.{Item, Till}
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TillSpec extends FlatSpec {

  "When I buy [“Cola”, “Coffee”] as String, cost" should "be 1.5" in {
    val items = List("Cola", "Coffee")
    assert(Till.purchase(items) == 1.5)
  }

  "When I buy [“Cola”, “Coffee”] as Item, cost" should "be 1.5" in {
    val items = List(Item.COLA, Item.COFFEE)
    assert(Till.purchaseItems(items) == 1.5)
  }

  "When I buy - mixed 1 nonexisting item, cost" should "be skipped for that item" in {
    val items = List("Cola", "Coffee", "ASDASDASD")
    assert(Till.purchase(items) == 1.5)
  }

  "When I buy - all nonexisting item, cost" should "be 0" in {
    val items = List("LJLKA", "ASDASDASD")
    assert(Till.purchase(items) == 0)
  }

  "When I buy - 0 item, cost" should "be 0" in {
    val items = List()
    assert(Till.purchase(items) == 0)
  }

  "When I buy - 1000 coffee, cost" should "be 1000" in {
    val items = (1 to 1000).map { _ => Item.COFFEE }.toList
    assert(Till.purchaseItems(items) == 1000)
  }

}
