name := "scala-excercise"

version := "1.0"

scalaVersion := "2.11.7"

scalacOptions ++= Seq(
	"-deprecation",	// 今後廃止の予定のAPIを利用している
	"-feature",			// 明示的に使用、もしくは注意しなければならない機能を利用している
	"-unchecked",	// 型消去などでパターンマッチが有効に機能しない場合
	"-Xlint",			// その他望ましい書き方や落とし穴についての情報
	"-Xcheckinit"	// 初期化チェック（未初期化のフィールドがあれば実行エラー）
)

resolvers ++= Seq(
	"Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

testOptions in ThisBuild += Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports")

libraryDependencies ++= Seq(
	"org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
	"org.pegdown" % "pegdown" % "1.4.2" % "test",
	"org.scala-lang.modules" %% "scala-xml" % "1.0.3",
	"junit" % "junit" % "4.11" % "test",
	// "com.typesafe.akka" %% "akka-actor" % "2.4.1",
	"com.typesafe.akka" % "akka-actor_2.11" % "2.4.1",
	"org.scalacheck" %% "scalacheck" % "1.12.5" % "test",
	"com.typesafe.slick" %% "slick" % "3.1.1",				// Slick（O/R まっぱー）
    "com.typesafe.slick" %% "slick-codegen" % "3.1.1",		// テーブル定義を自動出力
	"com.typesafe" % "config" % "1.3.0",					// 設定を記述するライブラリ
    "org.postgresql" % "postgresql" % "9.3-1102-jdbc41",	// postgresql JDBC
    "ch.qos.logback" % "logback-classic" % "1.1.2",			// ログ出力
    "org.scala-lang" % "scala-compiler" % "2.11.7"			// Scalaコンパイラ（evalを利用するため）
)
