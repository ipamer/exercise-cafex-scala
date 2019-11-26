package com.cafex.model

case class Bill(sum: Double, serviceCharge: ServiceCharge = ServiceCharge.PERCENT_0) {

  /**
   * Keep the bill immutable, so adding an item creates a new Bill.
   *
   * @param item
   * @return
   */
  def add(item: Item): Bill = {
    Bill(this.sum + item.price, this.howMuchServiceCharge(item))
  }

  def total: Double = {
    val sum = this.sum + (this.serviceCharge.value * this.sum / 100)
    BigDecimal(sum).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

  /**
   * Calculate the service charge for the current item being added to the bill,
   * then we want to keep the bigger service charge - either the one already on the bill or one for the new item.
   *
   * @param item
   * @return
   */
  private def howMuchServiceCharge(item: Item): ServiceCharge = {
    val charge = item match {
      case x if x.itemType == ItemType.FOOD && x.temperature == Temperature.HOT => ServiceCharge.PERCENT_20
      case x if x.itemType == ItemType.FOOD => ServiceCharge.PERCENT_10
      case _ => ServiceCharge.PERCENT_0
    }
    if (charge.value > this.serviceCharge.value) charge else this.serviceCharge
  }
}

/**
 * We have predefined service charge values, so let's model them.
 *
 * @param value
 */
sealed case class ServiceCharge(value: Int)

object ServiceCharge {

  object PERCENT_0 extends ServiceCharge(0)

  object PERCENT_10 extends ServiceCharge(10)

  object PERCENT_20 extends ServiceCharge(20)

}
