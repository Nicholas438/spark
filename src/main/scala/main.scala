package in.nic.sparktest

import org.apache.spark.sql.SparkSession


object main {
  def main(args:Array[String]): Unit = {
    val spark =  SparkSession.builder()
      .appName("sparktest")
      .master("local[*]")
      .config("spark.driver.bindAddress", "127.0.0.1")
      .getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    val df = spark.read
      .option("header", value = true)
      .option("inferSchema", value=true)
      .csv("data/AAPL.csv")
    
    df.show()
    df.printSchema()
  }
}

