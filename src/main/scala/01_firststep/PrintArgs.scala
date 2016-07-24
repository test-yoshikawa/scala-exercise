package firststep

/** コマンドライン引数をwhileで出力（改行あり） */
object PrintArgs {

  /** メイン処理
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
    // 命令型スタイル（改行あり）
    var i = 0
    while (i < args.length) {
      println(args(i))
      i += 1
    }

    // 命令型スタイル（改行なし）
    println()
    i = 0
    while (i < args.length) {
      if (i != 0) print(" ")
      print(args(i))
      i += 1
    }
    println()
  }
}