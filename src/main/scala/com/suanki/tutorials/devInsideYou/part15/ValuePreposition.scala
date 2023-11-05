package com.suanki.tutorials.devInsideYou.part15
//com.suanki.tutorials.devInsideYou.part15.ValuePreposition
object ValuePreposition extends App {


  type inttoString = Int=>String

  def f(g:inttoString):Unit={
    println(g(1337))
  }

  def g(number:Int):String={
    s"${Console.MAGENTA}  ${number.toString.reverse} ${Console.RESET}"
  }



}
