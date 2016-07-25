package implicit_conversion

import Implicit._ // 暗黙の型を利用したい場合はインポートをする
import scala.language.implicitConversions
import GreeterPrefs._

/** Implicit Conversion サンプル */
object Main {
  // warningが発生しないようにscala.language.implicitConversionsをimport
  implicit def doubleToInt(x: Double) = x.toInt

  /** メイン処理
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]): Unit = {
    println()
    // 暗黙のパラメータ１
    println("==== implicit parameter sample ====")
    val bobsPrompt = new PreferredPrompt("relax>")
    val bobsDrink = new PreferredDrink("cola")
    Greeter.greet("Bob")(bobsPrompt, bobsDrink)
    Greeter.greet("Joe") // 暗黙でGreeterPrefsを利用している

    // 暗黙のパラメータ２
    println()
    println("==== implicit parameter sample 2 ====")
    println(maxList(List(1, 5, 10, 3)))
    println(maxList(List(1.5, 5.2, 19.7, 3.14159)))
    println(maxList(List("one", "two", "three")))
    println(maxList2(List(1, 5, 10, 3)))
    println(maxList2(List(1.5, 5.2, 19.7, 3.14159)))
    println(maxList2(List("one", "two", "three")))

    // 暗黙の型変換
    println()
    println("==== Implicit convert type sample ====")
    val i: Int = 3.5
    println("i: Int: " + i + " (variable \"i\" converted type by doubleToInt method)")
    println()
  }

  /** リストの最大値を取得する
    *
    * @param elements List[T]
    * @param orderer T => Ordered[T]
    * @tparam T
    * @return 最大値
    */
  def maxList[T](elements: List[T])(implicit orderer: T => Ordered[T]): T =
  elements match {
    case List() => throw new IllegalArgumentException("empty list!")
    case List(x) => x
    case x :: rest =>
      val maxRest = maxList(rest) // 暗黙のうちに(orderer)が追加される
      if(x > maxRest) x     // 暗黙のうちにorderer(x)に変更される
      else maxRest
  }

  /** リストの最大値を取得する（可視境界を使用）
    *
    * @param elements
    * @tparam T T
    * @return
    */
  def maxList2[T <% Ordered[T]](elements: List[T]): T =
  elements match {
    case List() => throw new IllegalArgumentException("empty list!")
    case List(x) => x
    case x :: rest =>
      val maxRest = maxList2(rest) // 暗黙のうちに(orderer)が追加される
      if(x > maxRest) x     // 暗黙のうちにorderer(x)に変更される
      else maxRest
  }
}