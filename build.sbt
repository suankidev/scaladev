name := "spark-sbt-dev"

version := "0.1"

scalaVersion := "2.13.11"

idePackagePrefix := Some("com.suanki")


libraryDependencies += "org.apache.spark" %% "spark-core" % "3.3.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.2.0"


Compile/mainClass := Some("com.suanki.SuankiTransformer")


