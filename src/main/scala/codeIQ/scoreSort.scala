package codeiq

import scala.io.StdIn.readLine
import scala.collection.mutable.ListBuffer

/**
 * 以下のようなCSV形式のデータが標準入力された場合にソートする
 * ・英語、国語、数学の順に点数が高い方から順に並べる
 *
【入出力サンプル】
name,english,japanese,math
a,58,29,56
b,64,86,18
c,89,50,36
d,89,50,84
e,95,89,53
f,64,99,43
g,13,59,68
 */
object ScoreSort {

	def main(args: Array[String]) {
		var input = readLine()
		val header = input.split(",").toList // header項目
		val scores = new ListBuffer[List[String]]

		while(input.nonEmpty) {
			input = readLine()
			val datas = input.split(",")
			if (datas.size == 4) scores += datas.toList
		}

		println("===== output =====")
		sort(scores).foreach(score => println(score.mkString(", ")))
	}

	/**
	 * ソートする
	 */
	def sort(scores: ListBuffer[List[String]]) = {
		// ソート条件
		val condition = (a: List[String], b: List[String]) => {
			if (a(1).trim.toInt > b(1).trim.toInt) true
			else if (
				a(1).trim.toInt == b(1).trim.toInt &&
				a(2).trim.toInt > b(2).trim.toInt
				) true
			else if (
				a(1).trim.toInt == b(1).trim.toInt &&
				a(2).trim.toInt == b(2).trim.toInt &&
				a(3).trim.toInt > b(3).trim.toInt
				) true
			else false
		}

		scores.sortWith(condition)
	}
}