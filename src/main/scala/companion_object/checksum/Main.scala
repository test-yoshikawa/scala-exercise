package companion_object.checksum

/** クラスオブジェクト実行用 */
object Main{

  /** メイン処理
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
    println("execute ChecksumAccumulator")
    println("Chapter4 => " + CheckSumAccumulator.calculate("Chapter4"))
    println("Chapter4.1 => " + CheckSumAccumulator.calculate("Chapter4.1"))
    println("Chapter4 => " + CheckSumAccumulator.calculate("Chapter4"))
  }
}