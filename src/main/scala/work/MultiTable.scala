package work

/** 掛け算テーブル表示 */
object MultiTable {

  /** メイン実行
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) = {
    val table = multiTable()
    table.foreach(print)
    println()
  }

  /** 掛け算テーブルを作成
    * ・10×10のテーブル
    * ・各行をmakeRowで作成する
    *
    * @return 掛け算テーブル（String）
    */
  def multiTable() = {
    val tableSeq = for (row <- 1 to 10) yield makeRow(row)
    tableSeq.mkString("\n")
  }

  /** 行を文字列に変換して返す
    * ・makeRowSeqにより作成した掛け算テーブル行をmkString
    *
    * @param row 行
    * @return
    */
  def makeRow(row: Int) = makeRowSeq(row).mkString

  /** 指定した行の各列の計算結果を返す
    *
    * @param rowNum 行番号
    * @return 計算結果（Seq）
    */
  def makeRowSeq(rowNum: Int) = {
    for (col <- 1 to 10) yield {
      val prod = (rowNum * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    }
  }
}