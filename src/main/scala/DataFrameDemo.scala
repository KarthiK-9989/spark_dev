//import org.apache.spark.SparkConf
//import org.apache.spark.sql.{SaveMode, SparkSession}
//import org.apache.log4j.Logger
//import org.slf4j.LoggerFactory
//
//object DataFrameDemo {
//  def main(args: Array[String]): Unit = {
//    val logger = Logger.getLogger(getClass.getName)
//
//    val sparkConf = new SparkConf()
//      .setAppName("myfirstapplication")
//      .setMaster("local[*]")
//
//    val spark = SparkSession.builder()
//      .config(sparkConf)
//      .getOrCreate()
//
//    val url = "https://dummyjson.com/products/1"
//
//    val df = spark.read
//      .format("com.databricks.spark.avro")
//      .option("url", url)
//      .load()
//
//    df.show()
//
//    scala.io.StdIn.readLine()
//  }
//}
//
//
//
