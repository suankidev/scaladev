package com.suanki.tutorials.Exercise

object PlayGround extends App {


  val range = 1 to 5

  val doubler: Int => Int = x => x * x
  range.map(num => {
    var t = num * 5
    println(t)
  })


  val myfunction:Function2[Int,Int,String] =new Function2[Int,Int,String] {
    override def apply(v1: Int, v2: Int): String = s"$v1 $v2"
  }

  val myPartialFunction:PartialFunction[Int,String]=new PartialFunction[Int,String] {
    override def isDefinedAt(x: Int): Boolean = if(x >= 3) true else false

    override def apply(v1: Int): String = (v1*v1).toString
  }
  println()
  range.collect(myPartialFunction).foreach(println)


}
