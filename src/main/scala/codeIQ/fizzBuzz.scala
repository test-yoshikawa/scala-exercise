package codeIQ

object fizzBuzz {

	def main(args: Array[String]) {
		for( number <- 1 to 100) {
			println(checkFizzBuzz(number))
		} 
	}

	/**
	 * FizzBuzzのチェック
	 */
	def checkFizzBuzz(num: Int) = {
		var fizzBuzz = if (num % 3 == 0) "Fizz" else ""
		fizzBuzz = if (num % 5 == 0) fizzBuzz + "Buzz" else fizzBuzz
		fizzBuzz = if (fizzBuzz.isEmpty()) num.toString() else fizzBuzz
		fizzBuzz
	}
}