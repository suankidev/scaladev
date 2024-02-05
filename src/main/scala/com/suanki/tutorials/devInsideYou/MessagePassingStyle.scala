package com.suanki.tutorials.devInsideYou

object MessagePassingStyle {

  def main(args: Array[String]): Unit = {
    println("=" * 50)
    code(args)
    println("=" * 50)
  }

  def code(args: Array[String]): Unit = {

    def makeWithdraw(initialBalance: Int): Int => Int = {

      var balance: Int = initialBalance

      val withdraw: Int => Int = amount =>
        if (balance > amount) {
          balance = balance - amount
          balance
        } else
          sys.error("Insufficient fund")

      val deposit:Int=>Int = amount =>
        if(amount >= 1){
          balance = balance + amount
          balance
        }
      else{
          sys.error("It's only possible to deposit positive")
        }

      withdraw //deposit

    }

    val withdraw1 = makeWithdraw(initialBalance = 100)

    println(withdraw1(10))
    println(withdraw1(15))

  }

}
