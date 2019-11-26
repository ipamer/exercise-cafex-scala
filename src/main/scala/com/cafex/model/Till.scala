package com.cafex.model

object Till {

  def purchase(items: List[String]): Double = {
    Till.purchaseItems(items.flatMap { str => Item(str) })
  }

  def purchaseItems(items: List[Item]): Double = {
    val bill = items.foldLeft(Bill(0.0)) { (a, b) => a.add(b) }
    bill.total
  }

}
