name := "spark-sbt-dev"

version := "0.1"

scalaVersion := "2.13.11"

lazy val jacocoVersion = "0.8.11"

//idePackagePrefix := Some("com.suanki")



libraryDependencies ++= Seq(

  "org.apache.spark" %% "spark-core" % "3.3.2" % Provided,
  "org.apache.spark" %% "spark-sql" % "3.3.2" % Provided,
  "com.oracle.database.jdbc" % "ojdbc8" % "23.3.0.23.09" % Provided,
  "org.jacoco" % "org.jacoco.core" % jacocoVersion % Provided,
  "org.jacoco" % "org.jacoco.report" % jacocoVersion % Provided,
  "org.scalatest" %% "scalatest" % "3.2.17" % Test,
  "org.mockito" % "mockito-core" % "5.2.0" % Test
)

mainClass  := Some("com.suanki.stgTransformer.structuredAPI.BasicStructureOperation")


//pass option to the compiler
scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-feature"
)

//  "-feature ".
//  "-language:ReflectiveOption"