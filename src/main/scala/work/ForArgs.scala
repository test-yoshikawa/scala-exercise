package work

/** コマンドライン引数をFor, Foreachで出力 */
object ForArgs {

  /** メイン処理
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
    println()
    println("---- for (arg <- args) println(arg) ----")
    for (arg <- args) println(arg)

    println()
    println("---- args.foreach(arg => println(arg)) ----")
    args.foreach(arg => println(arg))

    println()
    println("---- args.foreach((arg: String) => println(arg)) ----")
    args.foreach((arg: String) => println(arg))

    println()
    println("---- args.foreach(println) ----")
    args.foreach(println)
    println()
  }
}