package com.suanki.fileRecon

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SparkSession


object FileRecon{

   def apply(args:Array[String])={
     val utils=new FileUtils
     val tableReader:TableReader = new TableReader
     val fileReader:FileReader = new FileReader

     val tableRecon = new FilRecon(utils, args,tableReader)
     val fileRecon = new FilRecon(utils, args,fileReader)

     FileResultPrinter.showResults(tableRecon.getStgDF(), tableRecon.getFinalTabDF(),fileRecon.getSourceDF())

  }

}

class FilRecon(utils: FileUtils, spark: SparkSession, parsedArgs: JobParams,readerType:Readers){


  def getSourceDF(): DataFrame = readerType.asInstanceOf[TableReader].createStgDataFrame

  def getFinalTabDF(): DataFrame = readerType.asInstanceOf[TableReader].createFinalTableDataFrame

  def getStgDF(): DataFrame = readerType.asInstanceOf[FileReader].createSourceTableDF


  def this(utils: FileUtils, args: Array[String],  readerType: Readers) = {
    this(utils, utils.getSparkSession(), utils.setParam(args),readerType)

  }


}
