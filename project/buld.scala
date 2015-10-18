import sbt._
import Keys._

object ScalaExcercise extends Build {
	lazy val root = Project(
			"scala-excercise",	// プロジェクト名
			file(".")			// プロジェクトのルートディレクトリ
		).settings(				// プロジェクトの設定
			Seq(
				version := "1.0",
				scalaVersion := "2.11.7"
			): _*
		)
}