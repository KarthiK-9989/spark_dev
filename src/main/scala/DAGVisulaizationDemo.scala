import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object DAGVisulaizationDemo {

   def main(args:Array[String]): Unit ={


     //How to create a spark session

     //How to reead---Reader API


     //Transformations   ---->


     //Writerr API
     val sparkconf = new SparkConf()
     sparkconf.set("spark.app.name", "myfirstapplication")
     sparkconf.set("spark.master", "local[*]");

     val spark = SparkSession.builder()
       .config(sparkconf)
       .getOrCreate()

              //inferschema--->production
     val df = spark.read  // -------->action  calculate how many partitions
       .format("csv") //
       .option("header", true)
       .option("inferschema",true)//---->10tb -200 columns ---> intelligenlt guess //action
       .option("path", "C:/Users/Karthik Kondpak/Desktop/Spark_Training/sampledata@1.csv")
       .load()
     df.show(30, false)   //show one of the action


     /*Actions
     1)READ
     2)INFERSCHEMA ---------------->3 jobs has created.
     3)SHOW
     note:
     ====
     Inferschema is not used in Production Environment why we wont use in the sense, it wont scans all the records
     it will scan few records and based on that , it will give you the output.

     That output is half correct


     */




     scala.io.StdIn.readLine();





   }
}
