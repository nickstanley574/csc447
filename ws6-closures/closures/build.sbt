name := "CSC347 Closures"
version := "1.0"
scalaVersion := "2.12.3"
scalacOptions ++= Seq("-deprecation", "-feature", "-target:jvm-1.8", "-unchecked")
javacOptions ++= Seq("-source", "1.8", "-target", "1.8")
resolvers ++= Seq("Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/")
enablePlugins(JavaAppPackaging)