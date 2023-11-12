package com.suanki.tutorials.devInsideYou

object PartialFunctionAndAnonymousClassesTwo extends App {

  type ~>[-Input,+Output] = PartialFunction[Input,Output]

  def toRomanNumeralDigit(number: Int):String={
    val partialFunction:Int=>String = ???

    partialFunction(number)
  }







}
