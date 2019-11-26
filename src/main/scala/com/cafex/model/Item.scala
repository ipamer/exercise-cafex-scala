package com.cafex.model

sealed case class Item(itemType: ItemType, temperature: Temperature, price: Double)

/**
 * There are is a predefined set of items in our shop so lock them down into a model.
 * This model can be constructed from a string.
 */
object Item {

  def apply(name: String): Option[Item] = name match {
    case x if x.toLowerCase == "Cola".toLowerCase => Some(Item.COLA)
    case x if x.toLowerCase == "Coffee".toLowerCase => Some(Item.COFFEE)
    case x if x.toLowerCase == "Cheese Sandwich".toLowerCase => Some(Item.CHEESE_SANDWICH)
    case x if x.toLowerCase == "Steak Sandwich".toLowerCase => Some(Item.STEAK_SANDWICH)
    case _ => None
  }

  object COLA extends Item(ItemType.DRINK, Temperature.COLD, 0.50)

  object COFFEE extends Item(ItemType.DRINK, Temperature.HOT, 1.00)

  object CHEESE_SANDWICH extends Item(ItemType.FOOD, Temperature.COLD, 2.00)

  object STEAK_SANDWICH extends Item(ItemType.FOOD, Temperature.HOT, 4.50)

}

sealed trait ItemType

object ItemType {

  object DRINK extends ItemType

  object FOOD extends ItemType

}

sealed trait Temperature

object Temperature {

  object COLD extends Temperature

  object HOT extends Temperature

}
