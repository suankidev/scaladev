package com.suanki.tutorials.devInsideYou

object PartialFunctionAndAnonymousClassesTwo extends App {

  type ~>[-Input,+Output] = PartialFunction[Input,Output]

  def toRomanNumeralDigit(number: Int):String={
//    val partialFunction:Int=>String = {
     number match {
      case 0 => "0: N"
      case 1 => "1: I"
      case 2 => "2: II"
      case 3 => "3: III"
      case 4 => "4: IV"
      case 5 => "5: V"
      case 6 => "6: VI"
      case 7 => "7: VII"
      case 8 => "8: VIII"
      case 9 => "9: IX"
    }

//    partialFunction(number)
  }


//  def toRomanNumeralDigitOrElse(number: Int):String= {
//    val partialFunction: Int ~> String = OnlyEvenDigits orElse onlyOddDigits
//    partialFunction(number)
//  }
//
//  val onlyOddDigits:Int ~> String={
//      case 0 => "0: N"
//      case 2 => "2: II"
//      case 4 => "4: IV"
//      case 6 => "6: VI"
//      case 8 => "8: VIII"
//
//  }
//
//  val OnlyEvenDigits:Int ~> String={
//      case 0 => "0: N"
//      case 1 => "1: I"
//      case 3 => "3: III"
//      case 5 => "5: V"
//      case 7 => "7: VII"
//      case 9 => "9: IX"
//  }

  0 until 10 map toRomanNumeralDigit foreach println
  println()
//  0 until 10 map toRomanNumeralDigitOrElse foreach println
//  0 until 10 collect toRomanNumeralDigit(_) foreach println

  val test:PartialFunction[Int,String] = new ~>[Int,String] {

    override def apply(v1: Int): String = s"$v1 apply"

    override def isDefinedAt(x: Int): Boolean = x >= 5


  }

  println(test(10))

}
