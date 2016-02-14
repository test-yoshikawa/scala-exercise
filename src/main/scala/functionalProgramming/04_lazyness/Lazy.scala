package functionalProgramming.lazyness

object Lazy {

	/**
	 * b: trueの場合、jが2階計算される
	 */
	def maybeTwice(b: Boolean, i: => Int) = if (b) i+i else 0

	/**
	 * b: trueの場合、lazyによってキャッシュされるため1回だけの計算
	 */
	def maybeTwice2(b: Boolean, i: => Int) = {
		lazy val j = i
		if (b) j + j else 0
	}

	def main(args: Array[String]): Unit = {
		println("==== maybeTwice ====")
		println(maybeTwice(true, {println("hi"); 1 + 41}))
		println("==== maybeTwice2 ====")
		println(maybeTwice2(true, {println("hi"); 1 + 41}))
	}
}