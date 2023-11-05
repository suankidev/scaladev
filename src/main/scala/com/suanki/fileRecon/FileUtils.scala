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


  def setParam(args: Array[String]): Map[String, String] = {

  Map("location" -> "EUROPE", "date" -> "2023-12-30", "database" -> "mydatabase")

}

  def getTableType(tableType: String): Boolean = if (tableType == "stg") false else true

}
