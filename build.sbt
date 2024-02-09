name := "spark-sbt-dev"

version := "0.1"

scalaVersion := "2.13.11"

lazy val jacocoVersion = "0.8.11"

scalafmtOnCompile := true

//idePackagePrefix := Some("com.suanki")

libraryDependencies ++= Seq(
  "org.apache.spark"           %% "spark-core"        % "3.3.2",
  "org.apache.spark"           %% "spark-sql"         % "3.3.2",
  "com.oracle.database.jdbc"    % "ojdbc8"            % "23.3.0.23.09",
  "org.jacoco"                  % "org.jacoco.core"   % jacocoVersion,
  "org.jacoco"                  % "org.jacoco.report" % jacocoVersion,
  "org.scalatest"              %% "scalatest"         % "3.2.17" % Test,
  "org.mockito"                 % "mockito-core"      % "5.2.0"  % Test,
  "com.typesafe.scala-logging" %% "scala-logging"     % "3.9.5",
  "org.slf4j"                   % "slf4j-api"         % "2.0.5",
  "org.slf4j" % "slf4j-log4j12" % "2.0.5" exclude ("log4j", "log4j"),
  "log4j"     % "log4j"         % "1.2.17",
  "com.oracle.database.jdbc" % "ojdbc6" % "11.2.0.4"
)

mainClass := Some(
  "com.suanki.stgTransformer.structuredAPI.BasicStructureOperation"
)

//pass option to the compiler
scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-feature"
)

//  "-feature ".
//  "-language:ReflectiveOption"
