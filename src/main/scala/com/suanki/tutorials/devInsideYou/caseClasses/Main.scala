package com.suanki.tutorials.devInsideYou.caseClasses

object Main extends App {

  println("=" * 50)
  // tuple are case classes
//  HowTuplesAreImplemented.code(args)

  // creating your owen tuple
//  HowTuplesAreImplemented.createYourOwnTuple(args)

  // suppose case class doesn't exist, we can create our own
  // goal is to run pattern match on humnan
  ConvertClassAsOfCaseClass.code(args)
  println("=" * 50)
}
