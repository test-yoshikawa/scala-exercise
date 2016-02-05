package functionalProgramming.gettingstarted

/**
 * フィボナッチ数列
 */
object FibonacciNumber {

	def main(args: Array[String]): Unit = {
		val result = fib(args(0).toInt)
		println("Fibonacci Number n = %s : %d".format(args(0), result))
	}

	/**
	 * n番目フィボナッチ数列の値を計算する
	 * @type Int result
	 */
	def fib(n: Int): Int = {
		def fibNum(n: Int, index1: Int, index2: Int): Int = {
			if(n <= 0) index1
			else fibNum(n-1, index2, (index1 + index2))
		}
		fibNum(n, 0, 1)
	}
}