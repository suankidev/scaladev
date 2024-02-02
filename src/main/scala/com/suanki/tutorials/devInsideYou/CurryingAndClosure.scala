package com.suanki.tutorials.devInsideYou

object CurryingAndClosure extends App {

  println("=" * 100)

  // var freeVariable:Int = 1337
  //
  def closedTerm(freeVariable: Int): Int => Int =
    boundVariable => freeVariable + boundVariable // anonymous function

  def closedTermOne(freeVariable: Int)(boundVariable: Int): Int =
    freeVariable + boundVariable

  def UncurriedclosedTermOne(freeVariable: Int, boundVariable: Int): Int =
    freeVariable + boundVariable

  println(closedTerm(freeVariable = 7)(8))
  println(UncurriedclosedTermOne(freeVariable = 7, boundVariable = 8))
  println(closedTermOne(freeVariable = 7)(8))

  //      //createTableDataFrame(buildQuery,dffromQuery)
  //  //            ==> buildQuery(buildSelect,buldWhere)
  //  //                     ==> buildSelect
  //  //                          ==>buildeWhere(fetchPartcolumn)
  //
  //  def buildSelect(tableName:String)=s"select * from $tableName"
  //
  //  def buildWhere(tableName:String, spark:SparkSession,f:(String,SparkSession) => List[String]) = {
  //    var where = "1 = 1 AND "
  //    f(tableName,spark) foreach(
  //      _ match {
  //        case "cobDate" => where = s"AND cobDate='2023-12-30'"
  //      }
  //    )
  //
  //  }
  //
  //  def buildQuery(tableName:String, spark:SparkSession, f:(String,SparkSession) => DataFrame)=
  //    s"select * from $tableName where ${f(tableName,spark)}"
  //
  //  def createDataFrames(tableName:String,spark:SparkSession, f:(String,SparkSession) => String, g:(String,SparkSession) => DataFrame)={
  //    var SqlQuery = f(tableName,spark)
  //
  //
  //  }
  //
  // createDataFrames(tableName,spark,dfType)

  def code(args: Array[String]): Unit = {

    println(addToX(10)(20))
    addToy(2)(40)
    println("=" * 30)

    def addToX(x: Int): Int => Int = {
      val y: Int => Int = y => x + y
      y
    }

    def addToy(x: Int)(y: Int): Unit = {
      1 to x foreach (_ => println(y))
    }

    def f(g: Int => String): Unit = {
      // g(x)
      println(g(45454))
    }

    def g(x: Int): String = s"${Console.MAGENTA} x ${Console.RESET}"

    f(g)

  }

  println("=" * 100)

}
