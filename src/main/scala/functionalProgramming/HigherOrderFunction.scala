package functionalProgramming

/**
 * 高階関数、多相関数、無名関数
 */
object HigherOrderFunction {

	/**
	 * 絶対値の計算
	 */
	def abs(n: Int): Int = if (n < 0) -n else n

	/**
	 * 階乗の計算
	 */
	def factorial(n: Int): Int = {
		def go(n: Int, acc:Int): Int = if(n <= 0) acc else go(n-1, n*acc)

		go(n, 1)
	}

	/**
	 * 絶対値の計算結果を出力
	 */
	private def formatAbs(x: Int) = {
		val msg = "The absolute value of %d is %d"
		msg.format(x, abs(x))
	}

	/**
	 * 階乗の計算結果を出力
	 */
	private def formatFactorial(n: Int) = {
		val msg = "The factorial of %d is %d."
		msg.format(n, factorial(n))
	}

	/**
	 * 出力する関数(formatAbsとformatFactorial)の共通化
	 */
	private def formatResult(name: String, n: Int, f: Int => Int) = {
		val msg = "The %s of %d is %d.(via anonymous function)"
		msg.format(name, n, f(n))

	}

	/**
	 * 単相関数の例（1つの型のデータだけを操作する関数）
	 */
	private def findFirst(as: Array[String], key: String): Int = {
		@annotation.tailrec
		def loop(n: Int): Int =
			if (n >= as.length) -1
			else if (as(n) == key) n
			else loop(n + 1)

		loop(0)
	}

	/**
	 * 多相関数の例
	 */
	private def findFirstPolyMorphic[A](as: Array[A], p: A => Boolean): Int = {
		@annotation.tailrec
		def loop(n: Int): Int =
			if (n >= as.length) -1
			else if (p(as(n))) n
			else loop(n + 1)

		loop(0)
	}

	/**
	 * excercise
	 */
	def partiall[A,B,C](a: A, f: (A, B) => C): B => C = (b: B) => f(a, b)
	def curry[A,B,C](f: (A, B) => C): A => (B => C) = a => b => f(a, b)
	def uncurry[A,B,C](f: A => B => C): (A, B) => C = (a, b) => f(a)(b)
	def compose[A,B,C](f: B => C, g: A => B): A => C = a => f(g(a))

	def main(args:Array[String]): Unit = {
		println(formatAbs(-42))
		println(formatFactorial(7))

		println(formatResult("absolute", -42, abs))
		println(formatResult("factorial", 7, factorial))

		val find = findFirstPolyMorphic(Array(7, 9, 13), (x: Int) => x == 9)
		println("findFirst Array(7, 9, 3): " + find)
	}
}