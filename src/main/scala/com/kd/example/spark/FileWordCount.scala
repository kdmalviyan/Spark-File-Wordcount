package com.kd.example.spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object MainObject {
  def main(args: Array[String]): Unit = {
    println("Hello Spark")
    val conf = new SparkConf().setAppName("SparkExample").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val dataset = sc.textFile("datasets.txt") // Reading data set from some location, in this case from local file system
    dataset
      .flatMap(_.split(" ")) // Split all lines with delemiter
      .map((_, 1)) // Assign each word occurance with 1
      .reduceByKey(_ + _) // Reduce by word or in simple words grouping data by words
      .filter(_._2 > 2) // Discarding words whose count is less then or equal to 2
      .collect() // Getting distributed data into driver (Not recommended with actual data because driver may not be able to handle all data from all executors.
      .foreach(t => println("Count for word " + t._1 + " is " + t._2)) // Printing to the console
    sc.stop();
  }
}