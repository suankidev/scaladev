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

}
