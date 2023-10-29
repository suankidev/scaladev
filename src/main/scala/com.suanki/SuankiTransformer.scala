package com.suanki

import com.suanki.sparkUtils.SparkUtils
import com.suanki.stgTransformer.BasicOfSpark

object SuankiTransformer    {

  def main(args: Array[String]): Unit = {

    println("Starting Transformer !")

    val util=new SparkUtils()

    val basicOfSpark = new BasicOfSpark(util.getSparkSession())
    //basicOfSpark.createDFByHand()
    basicOfSpark.dataFrames()


    //val complexDataType = new ComplexDataType(util.getSparkSession())
    //complexDataType.printrslt

    Thread.sleep(90000)


    println("End of the Prgramm!")
  }
}
