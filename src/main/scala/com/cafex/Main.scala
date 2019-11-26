package com.cafex

import com.cafex.model.Till

object Main extends App {
  println("Buying    : " + args.toList.mkString(", "))
  println("Please pay: " + Till.purchase(args.toList))
}
