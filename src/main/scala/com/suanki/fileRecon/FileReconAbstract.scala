package com.suanki.fileRecon

import org.apache.spark.sql.DataFrame


final case class JobParams(
runType:String,
dataPath:String
)


trait Readers

trait TableReaders extends Readers{
  var stgTableDF:DataFrame
  var finalTableDF:DataFrame
  def createStgDataFrame: DataFrame
  def createFinalTableDataFrame: DataFrame

}

trait FileReaders extends Readers{
  var sourceTableDF:DataFrame
  def createSourceTableDF:DataFrame
}



