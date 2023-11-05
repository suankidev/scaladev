package com.suanki.tutorials.oops

object BirthOfOOO extends App {


  val d: Int => Int = x => x + 10


  def code(args: Array[String]) = {

    object BankAccount{
      //companion object can access private members
    }



    class BankAccount(initialBalance: Int) { //default visibility of initialBalance is 'private[this] initialBalance:Int'

      private[this] var _balance: Int = initialBalance  //private[this] belongs to this object

      def withdraw(amount: Int): Unit = {
        //every time we calling _balance actually we are calling ==> this._balance
        if (this._balance >= amount) {
          this._balance = this._balance - amount
        } else
          sys.error("Insufficient funds")
      }

      def deposit(amount: Int): Unit = {
        if (this._balance >= 1) {
          this._balance += amount

        } else
          sys.error("It's only possible to deposit positive amount")
      }

      def balance: Int = _balance


    }


    val bankAccount1 = new BankAccount(initialBalance = 100)
    val bankAccount2 = new BankAccount(initialBalance = 1000)
    bankAccount1.withdraw(70)
    bankAccount1.deposit(20)

    println(bankAccount1.balance)
    println()



    def makeTransfer(from: BankAccount, amount: Int, to: BankAccount): Unit = {
      from.withdraw(amount)
      println(s"FROM AFTER WITHDRAW: ${from.balance}")
      to.deposit(amount)
      println(s"TO AFTER DEPOSIT: ${to.balance}")

    }

    makeTransfer(bankAccount1, 10, bankAccount2)



  }


  println("==" * 30)

  code(args)
  println("==" * 30)

}


/** middle */
/*


def code(args:Array[String])={

  type bankAccount=Symbol=>Any

  def bankAccount(initialBalance:Int):bankAccount={
    var balance:Int = initialBalance
    val withdraw:Int => Unit = amount =>
      if(balance >= amount) {
        balance =  balance - amount

      }else
        sys.error("Insufficient funds")

    val deposit:Int => Unit = amount =>
      if(balance >= 1){
        balance += amount

      }else
        sys.error("It's only possible to deposit positive amount")

    val getBalance:()=>Int=()=>balance

//    val dispatch:Symbol => Any = operation => {
    val dispatch:bankAccount = operation => {
      if (operation == Symbol("withdraw")) withdraw
      else if (operation == Symbol("getBalance")) getBalance
      else if (operation == Symbol("deposit")) deposit
      else sys.error(s"Uknown opetaion : $operation")
    }

    dispatch
  }



  val bankAccount1 = bankAccount(initialBalance = 100)
  val bankAccount2 = bankAccount(initialBalance = 1000)
  val withdraw1 = bankAccount1(Symbol("withdraw")).asInstanceOf[Int => Unit]
  val diposit1 =  bankAccount1(Symbol("deposit")).asInstanceOf[Int => Unit]

  withdraw1(70)
  println(bankAccount1(Symbol("getBalance")).asInstanceOf[() => Int]())
  println()

  diposit1(20)
  println(bankAccount1(Symbol("getBalance")).asInstanceOf[() => Int]())



def makeTransfer(from:bankAccount,amount:Int, to:bankAccount)= {
  def getBalance(account:bankAccount):Int = account(Symbol("getBalance")).asInstanceOf[() => Int]()
  from(Symbol("withdraw")).asInstanceOf[Int => Unit](amount)
  println(getBalance(from))
  to(Symbol("deposit")).asInstanceOf[Int => Unit](amount)
  println(getBalance(to))
}


  makeTransfer(bankAccount1,10,bankAccount2)


}


  println("=="*30)

  code(args)
  println("=="*30)

 */

/** initial dev * */

/*

  def bankAccount(initialBalance:Int):Symbol => (Int=>Int) ={
    var balance:Int = initialBalance
    val withdraw:Int => Int = amount =>
      if(balance >= amount) {
        balance =  balance - amount
        balance
      }else
        sys.error("Insufficient funds")

    val deposit:Int => Int = amount =>
      if(balance >= 1){
        balance += amount
        balance
      }else
        sys.error("It's only possible to deposit positive amount")

    val dispatch:Symbol => (Int => Int) = operation =>
      if(operation == Symbol("withdraw")){
      deposit
    }
    else if(operation == Symbol("deposit")){
      deposit
    }else{
      sys.error(s"Uknown opetaion : $operation")
    }

    dispatch
  }



  val bankAccount1 = bankAccount(initialBalance = 100)
  println(bankAccount1(Symbol("deposit"))(200))

 */