package com.suanki.tutorials.devInsideYou.caseClasses

object HowTuplesAreImplemented {
  println("=" * 50)

  //Tuples are
  /*
  immutable heterogeneous sequence of fixed length
  1) immutable: can't be change
  2) every element may have different type
  3) sequence mean there is an order
  4)
   */


  def code(args: Array[String]) = {

    //
    //    val tuple = Tuple3("a", 1, 'c')
    //    val tupleOne: Tuple3[String, Int, Char] = new Tuple3("a", 1, 'c')
    val tupleTwo = ("favouriteNumber", 1337, true)

    tupleTwo match {
      case (_, number, _) => println(number)
      case t => println(t._1)
    }


  }


  def createYourOwnTuple(args: Array[String]) = {

    //trait Equals extend Any
    //trait Product extends Equal
    //trait Product3[+T1,+T2,+T3] extends  Product
    //final case class Tuple3[+T1,+T2,+T3]  extends Product3[+T1,+T2,+T3]


    //    class T3(override val _1: String,
    //    override val _2: Int,
    //    override val _3: Boolean) extends Product3[String, Int, Boolean] {
    //
    //      override def canEqual(that: Any): Boolean = that.isInstanceOf[this.type] //T3 is also enough
    //    }
    class T3(override val _1: String,
             override val _2: Int,
             override val _3: Boolean) extends P3 {

      override def canEqual(that: Any): Boolean = that.isInstanceOf[this.type] //T3 is also enough
    }


    trait P3  extends Product{
      // Members declared in scala.Equals
      def canEqual(that: Any): Boolean = that.isInstanceOf[this.type]

      // Members declared in scala.Product
      def productArity: Int = 3
      def productElement(n: Int): Any = n match {
        case 0 => _1
        case 1 => _2
        case 2 => _3
        case _ => throw new IndexOutOfBoundsException(n.toString)
      }

      def _1:String
      def _2:Int
      def _3:Boolean

    }


    val mytyple3 = new T3("mystring", 1337, true)
    println(mytyple3._3)
    println(mytyple3.productArity)
    println(mytyple3.productElement(1))

    //product iterator from product

    println()

    val iterator: Iterator[Any] = mytyple3.productIterator

    iterator foreach println



  }


  //  code(args)
  //  createYourOwnTuple(args)


  println("=" * 50)
}
