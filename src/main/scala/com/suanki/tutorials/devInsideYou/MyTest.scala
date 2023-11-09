package com.suanki.tutorials.devInsideYou

object MyTest {


  def main(args: Array[String]) = {
    println("=" * 30)

    println(addToX(10)(20))
    addToy(2)(40)
    println("=" * 30)
  }


  def addToX(x: Int): Int => Int = {
    val y: Int => Int = y => x + y
    y
  }

  def addToy(x: Int)(y:Int):Unit= {
    1 to x foreach( _ =>
      println(y))
  }


  def f(g:Int => String):Unit={
    //g(x)
    println(g(45454))
  }

  def g(x:Int):String = s"${Console.MAGENTA} x ${Console.RESET}"

  f(g)







}
