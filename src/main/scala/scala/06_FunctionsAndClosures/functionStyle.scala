package scala.FunctionsAndClosures

/**
 * 関数型スタイル　サンプル
 */
object FunctionStyle {

	def main(args: Array[String]) {
		// 関数リテラルの例
		println("==== 関数リテラルの例 ====")
		var increase = (x: Int) => {
			println("increase 1!")
			x + 1
		}
		println(increase(10))

		// 関数リテラルの短縮形
		println("\n==== 関数リテラルの短縮形 ====")
		val someNumbers = List(-11, -10, -5, 0, 5, 10)
		someNumbers.filter((x: Int) => x > 0)	// 通常
		someNumbers.filter((x) => x > 0)		// パラメータの型は短縮できる
		val filteredList1 = someNumbers.filter(x => x > 0)			// 括弧は省略可能
		println(filteredList1)

		// プレースホルダー構文
		println("\n==== プレースホルダー構文 ====")
		val filteredList2 = someNumbers.filter(_ > 0)
		println(filteredList2)
		someNumbers.foreach(println _)
		val f = (_: Int) + (_: Int)
		println(f(10, 999))

		// 部分適用された関数
		println("\n==== 部分適用された関数 ====")
		val a = sum _
		println(a(1, 2, 3))
		val b = sum(1, _:Int, 3)
		println(b(4))

		// クロージャー
		println("\n==== クロージャー ====")
		var more = 4
		// クロージャー（自由変数を含む関数オブジェクト。x:束縛変数, more:自由変数）
		val addMore = (x: Int) => x + more
		println(addMore(11))
		var sum1 = 0
		someNumbers.foreach(sum1 += _)	// クロージャー
		println(sum1)
		val inc1 = makeIncreaser(1)
		val inc999 = makeIncreaser(999)
		println(inc1(1))
		println(inc999(1))

		// 関数呼び出しの特殊な形態
		// 連続パラメータ
		println("\n==== 連続パラメータ ====")
		echo()
		echo("one")
		echo("hello ", "world!")
		val arr = Array("What's", "up", "doc?")
		echo(arr: _*)	// 配列を渡す場合
		println("==== 名前付き引数 ====")
		println(sum(c = 1, b = 2, a = 4))

		println("\n==== パラメータのデフォルト値 ====")
		printTime();
		printTime(out = Console.err)
		printTime(divisor = 1000)

	}

	/**
	 * 連続パラメータを利用したメソッド
	 */
	def echo(args: String*) = for(arg <- args) println(arg)

	/**
	 * 加算クロージャー
	 */
	def makeIncreaser(more: Int) = (x: Int) => x + more

	/**
	 * 引数の合計
	 */
	def sum(a: Int, b:Int, c:Int) = a + b + c

	def printTime(out: java.io.PrintStream = Console.out, divisor: Int = 1) = {
		out.println("time = " + System.currentTimeMillis() / divisor)
	}
}