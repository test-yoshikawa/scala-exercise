package codeIQ

import scala.io.StdIn.readLine

/**
 * 1 から n まで連続する正の整数の中で「7」がいくつあるかを数える
 * ・「77」は2個として数える
 */
object CountSeven {

	def main(args: Array[String]) {
		val input = readLine()	// 標準入力

		val check = input.forall(_.isDigit)
		if (!check) {
			// 数値以外の値が含まれていた場合
			println("Error")
			return
		}
		val max = input.toInt	// 最大値
		var count = 0					// カウント
		for (num <- 1 to max) {
			// 数値の各桁が 7 のListを作成する
			val numChars = num.toString.toList.filter(_.getNumericValue == 7)
			count = count + numChars.size
		}
		println("==========")
		println("input: " + input)
		println("\"7\" count result: " + count)
	}

}