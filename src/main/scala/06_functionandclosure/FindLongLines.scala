package functionandclosure

/**
  * ファイルの内容を取得して、指定した行より長い行を出力する
  * Windowsでの実行の場合はsbt/sbtconfig.txtに「-Dfile.encoding=UTF-8」を追加
  * ⇒実行は成功するがコンソールは文字化けする
  * 【実行例】
  * sbt "run-main functionsandclosures.FindLongLines 10 ./src/main/scala/05_buildincontrol/MatchApi.scala"
  */
object FindLongLines {

  /** メイン実行
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
    val width = args(0).toInt
    for(arg <- args.drop(1)) LongLines.processLines(arg, width)
  }
}