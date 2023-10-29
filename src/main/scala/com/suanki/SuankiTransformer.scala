package com.suanki

import sparkUtils.{CommonUtils, SparkUtils}
import stgTransformer.ExerciseOnDF


object SuankiTransformer {

  def main(args: Array[String]): Unit = {

    println("Starting Transformer !")

    val sparkUtil = new SparkUtils()
    val commonUtil = new CommonUtils(sparkUtil.getSparkSession())

    val exerciseOnDF = new ExerciseOnDF(sparkUtil.getSparkSession(),commonUtil)
      exerciseOnDF.sparkTypeAndDatasets

//    val basicOfSpark = new BasicOfSpark(sparkUtil.getSparkSession(), commonUtil)



    //val complexDataType = new ComplexDataType(util.getSparkSession())
    //complexDataType.printrslt

    Thread.sleep(90000)


    println("End of the Programm !")
  }
}
