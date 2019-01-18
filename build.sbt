name         := "Spark Project"
version      := "1.0"
organization := "Tavant Technologies"

scalaVersion := "2.11.11"
// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.3.0"
// https://mvnrepository.com/artifact/org.apache.hbase/hbase
libraryDependencies += "org.apache.hbase" % "hbase" % "2.0.0" pomOnly()
