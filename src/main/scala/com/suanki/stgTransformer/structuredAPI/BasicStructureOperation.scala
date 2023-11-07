package com.suanki.stgTransformer.structuredAPI

import com.suanki.sparkUtils.SparkUtils
import org.apache.spark.sql.SparkSession

object BasicStructureOperation {


  def main(args: Array[String]): Unit = {

    println("="*30)
    println()

    val util: SparkUtils = new SparkUtils()
    val spark: SparkSession = util.getSparkSession()

    readFightDF(util, spark)

    println()
    println("="*30)
  }


  def readFightDF(utils: SparkUtils, session: SparkSession): Unit = {
    val option: Map[String, String] = Map("inferSchema" -> "true", "header" -> "true",
      "mode" -> "permissive")

    val path:String = raw"src/main/resources/data/fligt_data/2015-summary.csv"

    val flightData2015 = session.read.format("csv")
      .options(option).load(path)


//    flightData2015.show()
//    flightData2015.take(10).foreach(row => println(row.length, row(0), row.mkString("-") ) )


    flightData2015.sort("count").explain()


  }

}
