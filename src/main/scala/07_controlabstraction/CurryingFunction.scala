package controlabstraction

/** カリー化された関数 */
object CurryingFunction {

  /** メイン実行
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) = {
    val onePlus = curriedSum(1)_
    println(onePlus(2))
  }

  /** 普通の関数定義
    *
    * @param x Int
    * @param y Int
    * @return x + y
    */
  def plainOldSum(x: Int, y:Int) = x + y

  /** カリー化された関数
    *
    * @param x Int
    * @param y Int
    * @return x + y
    */
  def curriedSum(x: Int)(y: Int) = x + y
}