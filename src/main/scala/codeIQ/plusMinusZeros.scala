package codeIQ

import scala.io.StdIn.readLine

/**
 * 標準入力で入力した数値の中で2つの和が0になる組み合わせを計算する
 */
object plusMinusZeros {

	def main(args: Array[String]) {
		
		// 標準入力
		var input = readLine()
		var datas = new scala.collection.mutable.ListBuffer[Int]
 		while(input != "") {
			datas += input.toInt
 			input = readLine
 		}

 		// 0の組み合わせを計算する
 		println("calcualte plus minus zeros!")
 		println(datas);
 		var zeros = 0;
 		for(i <- datas; j <- datas if i > j) {
 			if (i + j == 0) {
 				zeros += 1
 			}
 		}
		println("plus minus zero count: " + zeros)
	}
}