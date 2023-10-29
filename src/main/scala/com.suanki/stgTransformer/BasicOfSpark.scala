package com.suanki
package com.suanki.stgTransformer


import org.apache.spark.sql.functions.{col, count}
import org.apache.spark.sql.types._
import org.apache.spark.sql.{SaveMode, SparkSession}


class BasicOfSpark(spark:SparkSession)  {



  def dataFrames():Unit={


    println("spark dataframe")

    val firstDf = spark.read.format("json")
      .option("inferSchema","false")
      .load("src/main/resources/data/cars.json")

    firstDf.show(truncate = false)
    firstDf.printSchema()
/**
    root
      |-- Acceleration: double (nullable = true)
      |-- Cylinders: long (nullable = true)
      |-- Displacement: double (nullable = true)
      |-- Horsepower: long (nullable = true)
      |-- Miles_per_Gallon: double (nullable = true)
      |-- Name: string (nullable = true)
      |-- Origin: string (nullable = true)
      |-- Weight_in_lbs: long (nullable = true)
      |-- Year: string (nullable = true)
     **/

    //get rows
    val first10Row = firstDf.take(10)

    first10Row.foreach(i => println(i))

    //spark types
    val longType = LongType

    //schema
    // schema
    val carsSchema = StructType(Array(
      StructField("Name", StringType),
      StructField("Miles_per_Gallon", DoubleType),
      StructField("Cylinders", LongType),
      StructField("Displacement", DoubleType),
      StructField("Horsepower", LongType),
      StructField("Weight_in_lbs", LongType),
      StructField("Acceleration", DoubleType),
      StructField("Year", StringType),
      StructField("Origin", StringType)
    ))


    val carsDFWithSchema = spark.read.format("json")
      .schema(carsSchema).load("src/main/resources/data/cars.json")



  }



  def createDFByHand()={

    //create rows by hand
    import org.apache.spark.sql.Row
    val myRow = Row("Sujeet","23","B.Tech")

    val emp = Seq((1,"Smith",-1,"2018","10","M",3000),
      (2,"Rose",1,"2010","20","M",4000),
      (3,"Williams",1,"2010","10","M",1000),
      (4,"Jones",2,"2005","10","F",2000),
      (5,"Brown",2,"2010","40","",-1),
      (6,"Brown",2,"2010","50","",-1)
    )

    val empColumns = Seq("emp_id","name","superior_emp_id","year_joined",
      "emp_dept_id","gender","salary")

    //schema auto inffered
    val empDF = spark.createDataFrame(emp)

    empDF.show()


    //create DFS with implicits
   import spark.implicits._
   val empToDF = emp.toDF("emp_id","name","superior_emp_id","year_joined",
     "emp_dept_id","gender","salary")

     empToDF.show(truncate = false)

    val dept = Seq(("Finance",10),
      ("Marketing",20),
      ("Sales",30),
      ("IT",40)
    )

    val deptColumns = Seq("dept_name","dept_id")
    val deptDF = dept.toDF("dept_name","dept_id")


  }


  def howManyJobsAndStages()= {

    val path = "C:\\Users\\sujee\\Desktop\\spark_input\\fligt_data\\"
    val surveydf= "C:\\Users\\sujee\\Desktop\\spark_input\\stack-overflow-developer-survey-2019\\survey_results_public.csv"
    val flightDf2010 = spark.read.format("csv").option("header",true).load(path+"2010*.csv")
    val flightDf2011 = spark.read.format("csv").option("header",true).load(path+"2011*.csv")
    val flightDf2015 = spark.read.format("csv").option("header",true).load(path+"2015*.csv")
    val stockSurvey2019 = spark.read.format("csv").option("header",true).load(surveydf)
    val allretailer = spark.read.format("csv").option("sep","|")
      .option("header",true).load("C:\\Users\\sujee\\Desktop\\spark_input\\retailer\\data\\inventory.dat")

      println(flightDf2010.rdd.getNumPartitions)

    println(s"flight df count ${flightDf2010.count()}")

     spark.conf.set("spark.sql.shuffle.partitions",5)
//   println(allretailer.rdd.getNumPartitions) //2
//   println(flightDf2010.rdd.getNumPartitions) //1
    //no of jobs till here is 5


//    allretailer.where(col("inv_quantity_on_hand") > 500 ).count()

    val df = flightDf2010.groupBy(col("DEST_COUNTRY_NAME"))
      .agg(count(col("count")).alias("counts"))
     .select("DEST_COUNTRY_NAME","counts")


    //df.show()
    println(df.rdd.getNumPartitions)

    df.write.format("csv").mode(SaveMode.Overwrite).option("header",true)
      .csv("C:\\Users\\sujee\\Desktop\\spark_output\\warehouse_dir\\retail_data")


  }

}
