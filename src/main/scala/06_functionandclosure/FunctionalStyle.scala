package functionandclosure

/** 関数型スタイル サンプル */
object FunctionalStyle {

  /** メイン実行
    *
    * @param args
    */
  def main(args: Array[String]) {
    // 関数リテラルの例
    println("==== Function literal example ====")
    val increase = (x: Int) => {
      println("increase 1!")
      x + 1
    }
    println(increase(10))

    // 関数リテラルの短縮形
    println("\n==== Shortened form of function literal ====")
    val someNumbers = List(-11, -10, -5, 0, 5, 10)
    someNumbers.filter((x: Int) => x > 0)	// 通常
    someNumbers.filter((x) => x > 0)		// パラメータの型は短縮できる
    val filteredList1 = someNumbers.filter(x => x > 0)			// 括弧は省略可能
    println(filteredList1)

    // プレースホルダー構文
    println("\n==== Placeholder ====")
    val filteredList2 = someNumbers.filter(_ > 0)
    println(filteredList2)
    someNumbers.foreach(println _)
    val f = (_: Int) + (_: Int)
    println(f(10, 999))

    // 部分適用された関数
    println("\n==== Partial function ====")
    val a = sum _
    println(a(1, 2, 3))
    val b = sum(1, _:Int, 3)
    println(b(4))

    // クロージャー
    println("\n==== Closure ====")
    var more = 4
    // クロージャー（自由変数を含む関数オブジェクト。x:束縛変数, more:自由変数）
    val addMore = (x: Int) => x + more
    println(addMore(11))
    more = 9
    println(addMore(11)) // 自由変数moreを変えるとaddMoreメソッドの結果も変わる
    var sum1 = 0
    someNumbers.foreach(sum1 += _)	// クロージャー
    println(sum1)
    val inc1 = makeIncrease(1)
    val inc999 = makeIncrease(999)
    println(inc1(1))
    println(inc999(1))

    // 関数呼び出しの特殊な形態
    // 連続パラメータ
    println("\n==== Serial parameter ====")
    echo()
    echo("one")
    echo("hello ", "world!")
    val arr = Array("What's", "up", "doc?")
    echo(arr: _*)	// 配列を渡す場合
    println("==== Named arguments ====")
    println(sum(c = 1, b = 2, a = 4))

    println("\n==== Default parameter ====")
    printTime()
    printTime(out = Console.err)
    printTime(divisor = 1000)

  }

  /** 引数分のprintln出力
    *
    * @param args 文字列（連続パラメータ）
    */
  def echo(args: String*) = for(arg <- args) println(arg)

  /** 加算する関数の定義
    *
    * @param more 加算する数値
    * @return function(x: Int): Int
    */
  def makeIncrease(more: Int) = (x: Int) => x + more

  /** 引数の合計
    *
    * @param a 数値
    * @param b 数値
    * @param c 数値
    * @return a + b + c
    */
  def sum(a: Int, b:Int, c:Int) = a + b + c

  /** システム日付を出力
    *
    * @param out PrintStream
    * @param divisor divisor
    */
  def printTime(out: java.io.PrintStream = Console.out, divisor: Int = 1) = {
    out.println("time = " + System.currentTimeMillis() / divisor)
  }
}