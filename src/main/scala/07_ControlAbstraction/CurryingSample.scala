package scala.ControlAbstraction

/**
 * @author Yuki Yoshikawa
 */
object CurryingSample {

	def main(args: Array[String]) = {
		val onePlus = curriedSum(1)_
		println(onePlus(2))
	}

	/**
	 * 普通の関数定義
	 */
	def plainOldSum(x: Int, y:Int) = x + y

	/**
	 * カリー化された関数
	 */
	def curriedSum(x: Int)(y: Int) = x + y
}