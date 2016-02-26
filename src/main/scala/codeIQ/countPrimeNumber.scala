package codeIQ

import scala.io.StdIn.readLine

/**
 * 指定した数値より小さい素数の個数を数える
 */
object CountPrimeNumber {

	def main(args: Array[String]) {
		val input = readLine()

		if (!input.forall(_.isDigit)) {
			println("Error")
		} else {
			println("==================")
			println("count prime numbers: " + countPrime(input))
		}
	}

	/**
	 * 素数を数える
	 */
	def countPrime(input: String) = {
		var count = if (input.toInt == 2) 1 else 0
		for(i <- 2 until input.toInt) if (checkPrime(i)) count = count + 1
		count
	}

	/**
	 * 素数かどうか判定する
	 */
	def checkPrime(num: Int) = {
		var prime = true
		for (i <- 2 until num) if (num % i == 0) prime = false
		prime
	}
}