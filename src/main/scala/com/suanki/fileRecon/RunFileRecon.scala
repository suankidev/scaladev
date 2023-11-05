package com.suanki.fileRecon



object RunFileRecon {

  def main(args: Array[String]): Unit = {

    val fileRecon = new FilRecon(new FileUtils, args)

    fileRecon.runTest


  }

}
