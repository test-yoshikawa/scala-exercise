package work

import scala.io.Source

/**
  * ファイルから行を読み出す
  * Windowsでの実行の場合はsbt/sbtconfig.txtに「-Dfile.encoding=UTF-8」を追加
  * ⇒実行は成功するがコンソールは文字化けする
  */
object LineCountFromFile {

  /** メイン処理
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
    println()
    println("##### ファイル内容 #####")
    val filename = "./src/main/scala/work/LineCountFromFile.scala"
    for (line <- Source.fromFile(filename).getLines()) {
      println(line.length + " " + line)
    }
    println()
    println()
    println("##### ファイル内容（整形版） #####")
    // getLines()はイテレーターを返すのでListに変換する必要がある
    val lines = Source.fromFile(filename).getLines().toList
    // 各行の最大文字数を取得する
    // List(1, 2, 3).reduceLeft(f) => f(f(1, 2), 3)の結果
    val longestLine = lines.reduceLeft((a, b) => if (a.length > b.length) a else b)
    // longestLineの文字数を取得する
    val maxWidth = widthOfLength(longestLine)
    for (line <- lines) {
      val numSpace = maxWidth - widthOfLength(line)
      val padding = " " * numSpace
      println(padding + line.length + " | " + line)
    }
    println()
  }

  /** 引数の文字数の桁を返す（ex.文字数113⇒3文字）
    *
    * @param s 文字列
    * @return 文字数の桁
    */
  def widthOfLength(s: String) = s.length.toString.length
}