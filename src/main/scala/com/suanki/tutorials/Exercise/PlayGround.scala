package com.suanki.tutorials.Exercise

import java.awt.Color
import scala.collection.{LinearSeq, SortedSet}
import scala.collection.mutable.Buffer

object PlayGround extends App {

  println("="*50)

//  scalaCollection
 // playWithList()/

  explainMapAndFlatMap()

  def show(someValue:Any):Unit={
    println(someValue)
  }
def scalaCollection:Unit={
  val x = 10
  val y = 20
  val z = 30
  val a = x
  val b = y
  val c= z
  println(Iterable("x", "y", "z"))
  show(Map("x" -> 24, "y" -> 25, "z" -> 26))
  show(Set(Color.red, Color.green, Color.blue))
  show(SortedSet("hello", "world"))
  show(Buffer(x, y, z))
  show(IndexedSeq(1.0, 2.0))
  show(LinearSeq(a, b, c))
}
  def playWithList() = {


    val listOfNumbers = List(1,2,3)
   val listOfFruits = List("apple","orange","pineapple")

    val totalList = listOfNumbers.concat(listOfFruits)


    show(totalList.head)
    show(totalList.tail)
    show(totalList.init)
    show(totalList.last)
    show(totalList.length)
    show(totalList.mkString(","))
    show(totalList(0))
    println()


    //List.fill()
    val fruitThreeTimes = List.fill(3)("apples")
    show(fruitThreeTimes)  //List(apples, apples, apples)


    val tabulatedNoOfList = List.tabulate(6)(n => n * n)
    show(tabulatedNoOfList) //List(0, 1, 4, 9, 16, 25)


    //reverse list
    show(tabulatedNoOfList.reverse)

    /*
    +  -> prepend
    ::  -> add to the beginning
    :::  -> add front of the list
    addString -->

     */

    show(10 :: listOfNumbers )  //List(10, 1, 2, 3)
    show(listOfNumbers ::: List(20,10))  //List(1, 2, 3, 20, 10)
    show(listOfNumbers.addString(new StringBuilder("test"))) //test123
    show(listOfNumbers.addString(new StringBuilder("test"),"="))
    show(listOfNumbers.contains(1))
    show(listOfNumbers.distinct)
    show(listOfNumbers.dropRight(1)) //1,2
    show(listOfNumbers.drop(1)) //2,3
    println()
    val t:Int=>Boolean=x=>x<=1
    show(listOfNumbers.dropWhile(x => t(x))) //drop if not satisfy //o/p 3

    val firstList = List(1,2,4,5)
    val secondList = List(1,2,4,5)
    val thirdList = List(1,2,4,5,6)

    show(firstList equals secondList)
    show(firstList equals thirdList)

    println()
    show(thirdList.exists(x => x==6))
    show(thirdList.exists(x => x>6))  //true/false
    show(thirdList.filter(x => x>2))  //list


    println()
    //checking if predicate hold for all the element in the list
    show(thirdList.forall(x => x.toString.endsWith("stg")))
    //applie a function f to all element

    show(thirdList.indexOf(4))  //2

  }


  def explainMapAndFlatMap():Unit={
    val l:List[Int] = List(2,4,5,6,7,8)
    show(l)

    val x:String = "thi is array"
    val y:List[List[Int]] = List(List(1,2,3),List(4,5,6))



  }
  println("="*50)

}
