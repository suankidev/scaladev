package com.suanki.tutorials.devInsideYou

object ObjectOrientedValues {

  def main(args: Array[String]): Unit = {
    println("=" * 50)
    code(args)
    println("=" * 50)
  }

  def code(args: Array[String]): Unit = {

    def f(g: Int => String, h: String => String, i: String => String): Unit = {
      val resultOfG: String = g(1337)
      val resultOfH: String = h(resultOfG)
      val resultOfI: String = i(resultOfH)
    }

    def g(number: Int): String = {
      Console.MAGENTA + number.toString.reverse + Console.RESET
    }

    def h(number: String): String = {
      number.toString.reverse
    }

    def i(string: String): String = string

    f(g, h, i)

  }
}
