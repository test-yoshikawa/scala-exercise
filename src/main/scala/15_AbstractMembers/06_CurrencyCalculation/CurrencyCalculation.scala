package abstractmembers

/** 通貨計算サンプル */
object CurrencyCalculation {

  /** メイン実行
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]): Unit = {
    val yen = Japan.Yen from US.Dollar * 100
    println("Japan.Yen from US.Dollar * 100 : " + yen + "(=yen)")

    val euro = Europe.Euro from yen
    println("Europe.Euro from yen : " +  euro)

    val dollar = US.Dollar from euro
    println("Europe.Euro from yen : " +  dollar)

    val cal1 = US.Dollar * 100 + dollar
    println("US.Dollar * 100 + dollar : " + cal1)

    // val cal2 = US.Dollar + Europe.Europe //コンパイルエラー
  }
}