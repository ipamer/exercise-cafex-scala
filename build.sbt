import sbt._

name := "exercise-cafex-scala"
organization := "com.cafex"

scalaVersion in ThisBuild := "2.11.12"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.8" % "test",
  "junit" % "junit" % "4.12" % "test"
)

mainClass in(Compile, run) := Some("com.cafex.Main")
