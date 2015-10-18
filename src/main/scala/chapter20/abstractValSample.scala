package scalableProgramming.chapter20

/**
 * @author Yuki Yoshikawa
 */
object abstractValSample {

	def main(args: Array[String]): Unit = {
		/***************************
		 * 抽象valの初期化
		 ***************************/
		println("===== 抽象valの初期化 =====")
		val x = 2


		// コンストラクタに渡される前にパラメータが評価されるため、numerArg, denomArgは0になる
		try {
			val result1 = new RationalTrait{
				val numerArg = 1 * x
				val denomArg = 2 * x	// denomArgが0となるためrequiredエラーになる
			}
			println(result1)
		} catch {
		  case t: Throwable => t.printStackTrace() // TODO: handle error
		}

		// 無名クラスによる事前初期化済みフィールドで初期化
		println()
		val result2 = new {
			val numerArg = 1 * x
			val denomArg = 2 * x
		} with RationalTrait
		println(result2)

		// クラス定義に含まれている事前初期化済みフィールドで初期化
		println()
		val result3 = new RationalClass(2, 6)
		println(result3)

		/***************************
		 * 遅延評価val
		 ***************************/
		println()
		println("===== 遅延評価val =====")
		println("Demoの初期化")
		println(Demo)
		println(Demo.x)	// ふつうはDemoの初期化時点でxも初期化されてしまう
		println()
		println("LazyDemoの初期化")
		println(LazyDemo)
		println(LazyDemo.x)	// lazy修飾子 : xを参照する時点で初期化させる

		println("遅延評価valによるRationalTraitの初期化")
		val y = 3
		val result4 = new LazyRationalTrait{
				val numerArg = 1 * y
				val denomArg = 2 * y
		}
		println(result4)

	}
}