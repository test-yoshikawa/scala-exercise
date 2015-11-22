name := "scala-excercise"

version := "1.0"

scalaVersion := "2.11.7"

resolvers ++= Seq(
	"Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

testOptions in ThisBuild += Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports")

libraryDependencies ++= Seq(
	"org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
	"org.pegdown" % "pegdown" % "1.4.2" % "test",
	"org.scala-lang.modules" %% "scala-xml" % "1.0.3",
	"junit" % "junit" % "4.11" % "test",
	"com.typesafe.akka" % "akka-actor" % "2.0.1",
	"org.scalacheck" %% "scalacheck" % "1.12.5" % "test"
)
