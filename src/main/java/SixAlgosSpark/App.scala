package SixAlgosSpark

/**
 * @author ${user.name}
 */

import org.apache.spark.sql.SparkSession
//import org.apache.spark.graphx.{GraphLoader, PartitionStrategy}
//import org.apache.spark.graphx.{GraphLoader, PartitionStrategy}
import org.apache.spark.graphx.{GraphLoader, PartitionStrategy}
object App {

  def main(args : Array[String]) {
    println( "Hello World!" )
    val spark = SparkSession.builder.master("local[*]").appName("Simple Spark Project").getOrCreate()
    val sc = spark.sparkContext
    //val conf = new SparkConf().setAppName("Count Triangles")
    //val sc = new SparkContext(conf)

    val graph = GraphLoader.edgeListFile(sc, "/followers.txt", true)
      .partitionBy(PartitionStrategy.RandomVertexCut)

    val triCounts = graph.triangleCount().vertices
    triCounts.take(6)
    triCounts.values.sum()
    triCounts.map(_._2).sum()
    triCounts.map(_._2).reduce(_ + _)
  }

}
