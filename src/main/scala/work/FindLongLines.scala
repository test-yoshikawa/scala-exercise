package work

import scala.io.Source

/**
  * ファイルの内容を取得して、指定した行より長い行を出力する
  * Windowsでの実行の場合はsbt/sbtconfig.txtに「-Dfile.encoding=UTF-8」を追加
  * ⇒実行は成功するがコンソールは文字化けする
  * 【実行例】
  * sbt "run-main work.FindLongLines 10 ./src/main/scala/api/MatchApi.scala"
  */
object FindLongLines {

  /** メイン実行
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
    val width = args(0).toInt
    for(arg <- args.drop(1)) processLines(arg, width)
  }

  /** 指定された行の幅より長い行を出力する
    *
    * @param filename ファイル名
    * @param width 幅
    */
  def processLines(filename: String, width: Int) {
    // 対象行の内容を出力(ローカル関数)
    def processLine(line: String) {
      if (line.length > width) println(filename + ": " + line.trim)
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines()) {
      processLine(line)
    }
  }
}