package codeIQ

import scala.io.StdIn.readLine

object KeyValueEvent {
	val keys = Array("HelloWorld", "FizzBuzz", "Prime", "Fibonacci")

	def main(args: Array[String]) {
		val input = readLine()

		if (!validateInput(input)) {
			println("Error")
			return
		}
		// key , value に分ける
		val keyValue = input.split(",").map(_.trim)

		val value = keyValue(1).toInt
		println("==================")
		keyValue(0) match {
			case "HelloWorld" =>
				println("output \"HelloWorld\": " + getHelloWorld(value))
			case "FizzBuzz" =>
				println("output FizzBuzz: " + getFizzBuzz(value))
			case "Prime" =>
				println(value + "-th Prime: " + getPrime(value) )
			case "Fibonacci" =>
				println(value + "-th Fibonacci: " + getFibonacci(value) )
		}
	}

	/**
	 * n 番目のフィボナッチ数列を求める
	 */
	def getFibonacci(n: Int): Int = {
		def fibNum(n: Int, index1: Int, index2: Int): Int = {
			if(n <= 0) index1
			else fibNum(n-1, index2, (index1 + index2))
		}
		fibNum(n, 0, 1)
	}

	/**
	 * 引数で指定した n 番目の素数を求める
	 */
	def getPrime(n: Int): Int ={
		var number = 2
		var prime = number
		var count = 0

		while (count != n) {
			var primeFlag = true
			for (i <- 2 until number) {
				if (primeFlag) primeFlag = if (number % i == 0) false else true
			}

			if (primeFlag) {
				count = count + 1
				prime = number
			}
			number = number + 1
		}

		prime
	}

	/**
	 * FizzBuzzを出力する
	 */
	def getFizzBuzz(number: Int): String = {
		var result = if (number % 3 == 0) "Fizz" else ""
		result = if (number % 5 == 0) result + "Buzz" else result
		result = if (result.isEmpty) number.toString else result
		result
	}

	/**
	 * 指定した引数分、「HelloWorld」を出力する
	 */
	def getHelloWorld(count: Int):String = {
			var output = ""
			for (i <- 1 to count) output = output + "HelloWorld"
			output
	}


	/**
	 * 入力値のバリデーション
	 */
	def validateInput(input: String): Boolean = {
		val keyValue = input.split(",").map(_.trim)
		var check = true

		if (keyValue.length != 2) {
			check = false
		} else {
			val key = keyValue(0)
			val value = keyValue(1)
			if( !keys.exists(_ == key) ) check = false
			if( !value.forall(_.isDigit) ||
					!(value.toInt >= 1 && value.toInt <= 15) ) check = false
		}

		check
	}
}