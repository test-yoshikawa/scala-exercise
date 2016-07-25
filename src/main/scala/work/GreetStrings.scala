package work

/** String型配列の操作 */
object GreetStrings {

  /** メイン処理
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
    println()
    val greetStrings = new Array[String](3)     // 作成・初期化する方法として推奨できない
    val numNames = Array("zero", "one", "two")  // 普段はこの初期化記法を使用するらしい

    greetStrings(0) = "Hello"
    greetStrings.update(1, ",")   // コンパイルする際は左記のコードに書き換えられる
    greetStrings(2) =  "world!\n"

    // 配列の中身を出力
    for (i <- 0 to 2) print(greetStrings(i))
    for (name <- numNames) print(name + " ")
    println("\n")
  }
}