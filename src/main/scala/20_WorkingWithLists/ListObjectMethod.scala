package workingwithlist

/** List 操作サンプル */
object ListObjectMethod {

  /** メイン実行
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
    // 要素からListを作る
    println("==== Create List by elements: apply ====")
    println(List.apply(1, 2, 3))

    // 数値の範囲を作る
    println("\n==== Create numeric range: range ====")
    println(List.range(1, 5))			// 1 ～ 4 のListを作成
    println(List.range(1, 9, 2))	// 1個飛ばしで作成

    // 同じ値のListを作る
    println("\n==== Create same elements List: fill ====")
    println(List.fill(5)('a'))	// サイズが5の'a'のListを作成
    println(List.fill(2, 3)('a'))	// sizeが3のListが要素のsizeが2のListを作成

    // 関数の実行結果による表の作成
    println("\n==== Create table by result of function: tabulate ====")
    val squares = List.tabulate(5)(n => n * n)
    println(squares)

    // 複数のListの連結
    println("\n==== Concat Lists: contact")
    println( List.concat(List('a', 'b'), List('c')) )
  }
}