addSbtPlugin("org.jetbrains" % "sbt-ide-settings" % "1.1.0")
//addSbtPlugin("com.github.sbt" % "sbt-ci-release" % "1.5.10")
//addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.11.0")

//addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "1.0.0")
//addSbtPlugin("com.typesafe.sbt" % "sbt-site" % "1.4.1")
//addSbtPlugin("com.lightbend.paradox" % "sbt-paradox" % "0.9.2")
//addSbtPlugin("com.typesafe.sbt" % "sbt-ghpages" % "0.6.3")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.6")

//added for reload
//Global / onChangedBuildSource := ReloadOnSourceChanges // IgnoreSourceChanges //ReloadOnSourceChanges

//scalfmt

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.2")

//adding revoler for plugin to restart the JVM in case recursive call
addSbtPlugin("io.spray" % "sbt-revolver" % "0.10.0")
