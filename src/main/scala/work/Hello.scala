package work

/** Hello World! */
object Hello {

  /** メイン処理
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
    println()
    println("Hello, world, from a script")
    println("max(3, 5): " + max(3, 5))
    println()
  }

  /** 2つの引数を比較して大きい値を返す
    *
    * @param x Int
    * @param y Int
    * @return 最大値(Int)
    */
  def max(x: Int, y: Int) = if(x > y) x else y
}