package api

/** Tuple サンプル */
object TupleApi {

  /** メイン処理
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
    println()
    // 異なる型の要素を持つことができる
    val pair = (99, "Scalable Programming")
    println(pair._1)
    println(pair._2)
    println()
  }
}