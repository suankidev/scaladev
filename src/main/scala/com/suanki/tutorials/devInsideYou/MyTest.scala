package com.suanki.tutorials.devInsideYou

object MyTest {


  def main(args: Array[String]) = {
    println("=" * 30)

    println(addToX(10)(20))
    addToy(10)(40)

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

}
