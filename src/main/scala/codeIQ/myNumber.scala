package codeIQ

import scala.io.StdIn.readLine
import scala.collection.mutable.ListBuffer

/**
 * マイナンバーのチェックディジットを計算する
 * ・数字11桁の場合、マイナンバーのチェックデジット1桁を出力
 * ・数字12桁の場合、チェックデジットの値が正しければOK、間違っていればNGを出力
 * ・数字以外が入っている、もしくは11桁や12桁でない場合、Errorと出力
 * ・空行入力で終了
 */
object myNumber {

	def main(args: Array[String]) {
		var input = readLine()	// 標準入力
		var checkDigit = -1			// チェックディジット

		while(input != "") {
			val check = input.forall(_.isDigit)
			if (!check) {
				// 数値でない場合はエラー
				println("Error")
			} else {
				input.length match{
					case 11 => 
						// 11桁の場合はチェックディジットを計算する
						checkDigit = calcCalcDigit(input)
						println("checkDigit: " + checkDigit)

					case 12 =>
						// 12桁の場合はチェックディジットが正しいか判定する
						var num = input.toList
						if (num(num.length - 1).getNumericValue == checkDigit) {
							println("OK")
						} else {
							println("NG")
						}

					case _ => println("Error")	// 桁数が上記以外の場合はエラー
				}
			}
			input = readLine()
		}
	}

	/**
	 * チェックディジットを計算する
	 * 　・１１―（（ｎ＝１（シグマ）１１（Ｐｎ×Ｑｎ））を１１で除した余り）
	 * 　・ただし、（ｎ＝１（シグマ）１１（Ｐｎ×Ｑｎ））を１１で除した余り≦１の場合は、０とする
	 * 　・Ｐｎ　個人番号を構成する検査用数字以外の十一桁の番号の最下位の桁を１桁目としたときのｎ桁目の数字
	 * 　・Ｑｎ　１≦ｎ≦６のとき　ｎ＋１　７≦ｎ≦１１のとき　ｎ―５
	 */
	def calcCalcDigit(input: String) = {
		def calc(digit: Int, index: Int, number: ListBuffer[Int]): Int = {
			if(index > number.length) {
				val result = 11 - (digit % 11)
				if (result <= 1) 0 else result 
			} else {
				val Qn = if (1 <= index && index <= 6) index + 1 else index - 5 
				val Pn = number(index - 1)
				calc(digit + (Pn * Qn), index + 1, number) 
			}
		}
		val digits = new ListBuffer[Int]
		input.foreach(digits += _.getNumericValue)
		calc(0, 1, digits.reverse)
	}
}