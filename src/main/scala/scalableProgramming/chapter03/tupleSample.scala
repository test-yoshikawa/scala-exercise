package scalableProgramming.chapter03

/**
 * @author Yuki Yoshikawa
 */
object tupleSample {
	def main(args: Array[String]): Unit = {
		// 異なる型の要素を持つことができる
		val pair = (99, "Luftballons")
		println(pair._1)
		println(pair._2)
	}
}