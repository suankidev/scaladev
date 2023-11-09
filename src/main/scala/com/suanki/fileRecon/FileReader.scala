package com.suanki.fileRecon
import org.apache.spark.sql.DataFrame

class FileReader extends FileReaders {
  override var sourceTableDF: DataFrame = _

  override def createSourceTableDF: DataFrame = ???
}
