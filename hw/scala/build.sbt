name := "CSC447"

version := "1.0"

scalaVersion := "2.12.3"

scalacOptions ++= 
  Seq("-deprecation",
      "-feature",
      "-target:jvm-1.8",
      "-unchecked")

resolvers ++= Seq(
  "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies ++= Seq(
  "org.scalatest"  %% "scalatest"  % "3.0.4"  % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.5" % "test"
)
