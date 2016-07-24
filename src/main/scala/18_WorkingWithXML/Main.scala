package workingwithxml

/**
  * Xmlサンプル実行
  */
object Main {

  /** メイン実行
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
    val therm = new CCTherm()
    val xml = therm.toXml
    println(xml)
  }
}