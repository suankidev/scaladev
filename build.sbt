name := "spark-sbt-dev"

version := "0.1"

scalaVersion := "2.13.11"

//idePackagePrefix := Some("com.suanki")



libraryDependencies ++= Seq(
     "org.apache.spark" %% "spark-core" % "3.3.0",
    "org.apache.spark" %% "spark-sql" % "3.2.0" ,
    "com.oracle.database.jdbc" % "ojdbc8" % "23.3.0.23.09"
)

//mainClass := Some("com.suanki.SuankiTransformer")


//pass option to the compiler
scalacOptions ++= Seq(
  "-deprecation",

)
//  "-feature ".
//  "-language:ReflectiveOption"