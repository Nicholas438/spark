ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12" // Spark 3.5.4 supports Scala 2.12 or 2.13, but NOT 3.x

lazy val root = (project in file("."))
  .settings(
    name := "sparktest",
    idePackagePrefix := Some("in.nic.sparktest")
  )

val sparkVersion = "3.5.4"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion ,
  "org.apache.spark" %% "spark-sql" % sparkVersion
)
// Suppress illegal reflective access warnings
javacOptions ++= Seq("--add-opens=java.base/java.nio=ALL-UNNAMED")
javaOptions += "--add-opens=java.base/java.nio=ALL-UNNAMED"
