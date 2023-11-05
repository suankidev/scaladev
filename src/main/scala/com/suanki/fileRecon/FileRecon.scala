package com.suanki.fileRecon

import org.apache.spark.sql.{DataFrame, SparkSession}


class FilRecon(utils: FileUtils, spark: SparkSession, parsedArgs: JobParams) {

  var stgQuery: String = "default stg query"
  var finalTableQuery: String = "default final query"

  var sourceTableDF: DataFrame = spark.emptyDataFrame
  var stgTableDF: DataFrame = spark.emptyDataFrame
  var finalTableDF: DataFrame = spark.emptyDataFrame


  def this(utils: FileUtils, args: Array[String]) = {
    this(utils, utils.getSparkSession(), utils.setParam(args))

  }



   def createStgDataFrame: Unit = {

    stgTableDF = spark.range(5).toDF("stgDF")
  }

   def createFinalTableDataFrame: Unit = finalTableDF = spark.range(10).toDF("finaltabledf")

  def createSourDF(spark: SparkSession, initialDF: DataFrame, parsedArgs: JobParams): DataFrame = {

    initialDF
  }

   def readDF: Unit = {

    val initialDF = spark.range(15).toDF("sourcefiledf")

    sourceTableDF = createSourDF(spark, initialDF, parsedArgs)

  }

   def buildWhere(tableType: String): String = {
    var whereClause = "1=1 and "

    utils.fetchPartitionCols("tablename", spark).foreach(
      element => element match {

        case "location" => whereClause = s"$whereClause location='EUR'"

        case "date" => whereClause = s"$whereClause location='EUR'"
      }
    )
    whereClause
  }


   def buildSelect(tableType: String): String =
    if (utils.getTableType(tableType)) {
      s"select * from finaltable"
    } else {
      s"select * from stgTable"
    }

  def queryBuilder(tableName:String, spark:SparkSession): Symbol =>(Int=>Int) = d
//
//    var selectPart:String = buildSelect(tableName,utils.getTableType())
//    val dispatch:Symbol => (Int=>Int)=
//      if(tableName.toLowerCase.endsWith("stg") == Symbol("stg"))
//
//      else{
//
//      }
//

    val x:Int=>Int = x => x+10
   val d:Symbol=>(Int=>Int)=opType=>if(Symbol("opertaionType") == "dep") x else x



  def runTest = {

    // queryBuilder
    createStgDataFrame
    createFinalTableDataFrame
    readDF

    println(s"stgtabledf ${stgTableDF.count()}")
    println(s"finaltabledf ${finalTableDF.count()}")
    println(s"sourcetabledf ${sourceTableDF.count()}")

  }


}
