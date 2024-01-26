package com.suanki.tutorials.devInsideYou

object BirthOfOOO extends App {

  val d: Int => Int = x => x + 10

  def code(args: Array[String]) = {

    object BankAccount {
      // companion object can access private members
    }

    class BankAccount(initialBalance: Int) { // default visibility of initialBalance is 'private[this] initialBalance:Int'

      private[this] var _balance: Int =
        initialBalance // private[this] belongs to this object

      def withdraw(amount: Int): Unit = {
        // every time we calling _balance actually we are calling ==> this._balance
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

    def makeTransfer(
        from: BankAccount,
        amount: Int,
        to: BankAccount
    ): Unit = {
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
