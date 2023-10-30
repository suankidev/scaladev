package com.suanki.fileRecon

import org.apache.spark.sql.{DataFrame, SparkSession}

trait TableReader {

  def createStgDataFrame: Unit

  def createFinalTableDataFrame: Unit
}

trait QueryBuilder {

  def builWhere(tableType: String): String

  def buildSelect(tableType: String): String
}

trait FileReader {

  def readDF: DataFrame

}

class FileUtils {


  def getSparkSession(database: String = "default"): SparkSession =
    SparkSession.builder().appName("test").master("local[2]").getOrCreate();


  def fetchPartitionCols(tableName:String, spark: SparkSession): List[String] = {

    println(s"sparkSession: $spark")
    println("fetching partition column")
    List("location", "date")
  }


  def setParam(args: Array[String]): Map[String, String] = {

    Map("location" -> "EUROPE", "date" -> "2023-12-30", "database" -> "mydatabase")

  }

  def getTableType(tableType: String): Boolean = if (tableType == "stg") false else true

}


class FilRecon(utils: FileUtils, spark: SparkSession, parsedArgs: Map[String, String]) extends TableReader with FileReader with QueryBuilder {

  var stgQuery: String = "default stg query"
  var finalTableQuery: String = "default final query"

  var sourceTableDF: DataFrame = spark.emptyDataFrame
  var stgTableDF: DataFrame = spark.emptyDataFrame
  var finalTableDF: DataFrame = spark.emptyDataFrame


  def this(utils: FileUtils, args: Array[String]) = {
    this(utils, utils.getSparkSession(), utils.setParam(args))

  }


  override def createStgDataFrame: Unit={

    this.stgTableDF = spark.range(5).toDF("stgDF")
  }

  override def createFinalTableDataFrame: Unit =  this.finalTableDF = spark.range(10).toDF("finaltabledf")


  override def readDF: DataFrame =  this.sourceTableDF = spark.range(15).toDF("sourcefiledf")

  override def builWhere(tableType: String): String = {
    var whereClause = "1=1 and "

    utils.fetchPartitionCols("tablename",spark).foreach(
      element => element match {

        case "location" => whereClause = s"$whereClause location='EUR'"

        case "date" => whereClause = s"$whereClause location='EUR'"
      }
    )
    whereClause
  }


  override def buildSelect(tableType: String) :String=
    if (utils.getTableType(tableType)) {
      s"select * from finaltable"
    } else {
      s"select * from stgTable"
    }

  def queryBuilder(): Unit = {
    this.stgQuery = s"${buildSelect("stg")} where ${builWhere("stg")}"
    this.finalTableQuery = s"${buildSelect("final")} where ${builWhere("final")}"

  }


  def runTest = {

    queryBuilder
    createStgDataFrame
    createFinalTableDataFrame
    readDF

    println(s"stgtabledf ${stgTableDF.count()}")
    println(s"finaltabledf ${finalTableDF.count()}")
    println(s"sourcetabledf ${sourceTableDF.count()}")


  }


}

object MyTest {

  def main(args: Array[String]): Unit = {


    val fileRecon = new FilRecon(new FileUtils, args)

    fileRecon.runTest

  }

}
