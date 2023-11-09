package com.suanki.fileRecon
import org.apache.spark.sql.DataFrame

class TableReader extends TableReaders {
  override var stgTableDF: DataFrame = _
  override var finalTableDF: DataFrame = _

  override def createStgDataFrame: DataFrame = ???

  override def createFinalTableDataFrame: DataFrame = ???
}
