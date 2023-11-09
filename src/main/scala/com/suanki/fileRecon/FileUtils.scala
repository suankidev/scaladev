package com.suanki.fileRecon

import org.apache.spark.sql.SparkSession

class FileUtils {


  def getSparkSession(database: String = "default"): SparkSession =
  SparkSession.builder().appName("test").master("local[2]").getOrCreate();


  def fetchPartitionCols(tableName: String, spark: SparkSession): List[String] = {

  println(s"sparkSession: $spark")
  println("fetching partition column")
  List("location", "date")
}


  def setParam(args: Array[String]):JobParams = {
    var paramsArgumnents:Map[String, String] = Map.empty
    val listOfParam= List("runType","dataPath")
    for(idx <- 0 until args.length){
    paramsArgumnents += (listOfParam(idx) -> args(idx))
    }

    JobParams(paramsArgumnents.getOrElse("runType","stgtable"),
      paramsArgumnents.getOrElse("dataPath","testPath")
    )

}

  def getTableType(tableType: String): Boolean = if (tableType == "stg") false else true



  def readDF(spark: SparkSession): Unit = {

    val initialDF = spark.range(15).toDF("sourcefiledf")

//    sourceTableDF = createSourDF(spark, initialDF, parsedArgs)

  }

  def buildWhere(tableType: String,spark:SparkSession): String = {
    var whereClause = "1=1 and "

    fetchPartitionCols("tablename", spark).foreach(
      element => element match {

        case "location" => whereClause = s"$whereClause location='EUR'"

        case "date" => whereClause = s"$whereClause location='EUR'"
      }
    )
    whereClause
  }


  def buildSelect(tableType: String): String =
    if (getTableType(tableType)) {
      s"select * from finaltable"
    } else {
      s"select * from stgTable"
    }

}
