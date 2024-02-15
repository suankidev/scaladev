package com.suanki.tutorials.devInsideYou.visibility
// private[this]          //only accessible to current object
// example
class A {

  private[A] def foo(): Unit       = println("I'm foo , only accessible to A")
  protected[this] def foo1(): Unit = println("I'm foo , only accessible to A")

  def callingFoo: Unit = foo()
}

class B extends A {}

object VisibilityTest {

  def main(args: Array[String]): Unit = {
    val a = new A
    val b = new B
//    a.foo()
    a.callingFoo
//    b.foo1()
  }

}
