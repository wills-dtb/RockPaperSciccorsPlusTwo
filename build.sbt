name := "RockPaperSciccorsPlusTwo"

version := "0.1"

scalaVersion := "2.12.8"

val circeVersion = "0.10.0"

lazy val root = (project in file(".")).enablePlugins(SbtTwirl)
sourceDirectories in (Compile, TwirlKeys.compileTemplates) := (unmanagedSourceDirectories in Compile).value

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

libraryDependencies ++= Seq(
  "de.heikoseeberger" %% "akka-http-circe" % "1.25.2",
  "com.typesafe.akka" %% "akka-http" % "10.1.8",
  "com.typesafe.akka" %% "akka-http-core" % "10.1.8"
)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.23",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.23" % Test
)
