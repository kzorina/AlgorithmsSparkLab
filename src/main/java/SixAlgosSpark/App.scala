package SixAlgosSpark

/**
 * @author ${user.name}
 */

import org.apache.spark.graphx.{GraphLoader, PartitionStrategy}
import org.apache.spark.{SparkConf, SparkContext}
object App {

  def main(args : Array[String]) {
    println( "Hello World!" )

    // ------------ COMPILE CODE
    //val spark = SparkSession.builder.master("local[*]").appName("Simple Spark Project").getOrCreate()
    //val sc = spark.sparkContext
    // ------------ COMPILE CODE END

    // ------------ JAR CODE
    val conf = new SparkConf().setAppName("Count Triangles")
    val sc = new SparkContext(conf)
    // ------------ JAR CODE END

    sc.setLogLevel("ERROR")
    println("Working with graph from followers.txt")
    val graph = GraphLoader.edgeListFile(sc, "followers.txt", true)
      .partitionBy(PartitionStrategy.RandomVertexCut)
    /*
    // DEFAULT VERSION //
    val triCounts = graph.triangleCount().vertices
    println(triCounts.take(6).toString)
    println(triCounts.values.sum())
    println(triCounts.map(_._2).sum())
    println(triCounts.map(_._2).reduce(_ + _))

    */

    //println(CustomTriangleCount.run(graph).vertices.map(_._2).reduce(_ + _))
    println("You have this amount of triangles in graph: "+CustomTriangleCount.run(graph).vertices.map(_._2).reduce(_ + _)/3)
  }

}
