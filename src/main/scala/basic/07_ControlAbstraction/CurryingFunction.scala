package basic.controlabstraction

/**
 * カリー化された関数
 */
object CurryingFunction {
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