package com.suanki.sparkUtils

import org.apache.spark.sql.{DataFrame, SparkSession}

class CommonUtils(spark:SparkSession) {


  def readDF(path: String,filetype:String="parquet", opt: Map[String, String], isSchema: Boolean = false, dfSchema: String="a b c"):DataFrame = {

    println(s"path: $path")
    if (isSchema) {
      spark.read.format(filetype).options(opt)
        .schema(dfSchema)
        .load(path)
    }
    else
      spark.read.format(filetype).options(opt).load(path)


  }


  def readDFWithFileName(file_name:String)={

    spark.read.format("json").options(Map("inferSchema" -> "true", "header" -> "true"))
      .load(raw"C:\Users\sujee\Desktop\spark-sbt-dev\src\main\resources\data\${file_name}.json")
  }


}



