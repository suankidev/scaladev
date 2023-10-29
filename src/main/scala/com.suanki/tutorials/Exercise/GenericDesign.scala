package com.suanki
package com.suanki.tutorials.Exercise

object GenericDesign extends App{


class MyList[A]{

}

object MyList {
  def empty[A] = new MyList[A]
}

  val emptyListOfintegers = MyList.empty[Int]
  

}