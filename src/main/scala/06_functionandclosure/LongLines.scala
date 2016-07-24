package functionandclosure

import scala.io.Source

/** ファイルの行に関するオブジェクト */
object LongLines {

  /** 指定された行の幅より長い行を出力する
    *
    * @param filename ファイル名
    * @param width 幅
    */
  def processLines(filename: String, width: Int) {
    // 対象行の内容を出力
    def processLine(line: String) {
      if (line.length > width) println(filename + ": " + line.trim)
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines()) {
      processLine(line)
    }
  }
}