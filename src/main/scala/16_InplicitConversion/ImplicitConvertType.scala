package implicitconversion

import scala.language.implicitConversions // warningが発生しないようにimport

/** ImplicitConvertTypeオブジェクト */
object ImplicitConvertType {
  implicit def doubleToInt(x: Double) = x.toInt

  /** メイン実行
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]): Unit = {
    println("==== Implicit convert type sample ====")
    val i: Int = 3.5
    println("i: Int: " + i + " (variable \"i\" converted type by doubleToInt method)")
  }
}