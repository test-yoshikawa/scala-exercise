package classandobject

/** クラスオブジェクト実行用 */
object Main{

  /** メイン実行
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
    //=======================
    // シングルトン サンプル
    //=======================
    println("execute ChecksumAccumulator")
    println("Chapter4 => " + CheckSumAccumulator.calculate("Chapter4"))
    println()
    println("Chapter4.1 => " + CheckSumAccumulator.calculate("Chapter4.1"))
    println()
    println("Chapter4 => " + CheckSumAccumulator.calculate("Chapter4"))
  }
}