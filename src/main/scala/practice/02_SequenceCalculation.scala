package practice

import scala.tools.reflect.ToolBox
import scala.reflect.runtime.currentMirror

/**
 * 並んでいる数字の各桁に四則演算の演算子を入れて計算したときに
 * 元の数の桁を逆から並べた数字と同じになるものを検索したい。
 * 1000 ~ 9999のうち、上記の条件を満たす数を求めてください。
 * A.5931
 * ※処理にものすごい時間がかかる(パフォーマンスチューニングを検討する必要あり)
 * ※範囲を小さくしたほうが良いかも
 * ※org.scala-lang scala-compilerライブラリを追加する必要あり
 */
object SequenceCalculation {
  def main(args: Array[String]) = {
    val toolbox = currentMirror.mkToolBox()

    val op = Seq("+", "-", "*", "/", "")
    for(i <- 1390 until 1400) {
      var c = i.toString
      for(j <- 0 until op.length) {
        for(k <- 0 until op.length) {
          for(l <- 0 until op.length) {
            val source = c(3) + op(j) + c(2) + op(k) + c(1) + op(l) + c(0)
            if (source.length > 4) {
              try {
                val tree = toolbox.parse(source)
                val result = toolbox.eval(tree).asInstanceOf[Integer]
                if(i == result) println(source + " = " + i)
              } catch {
                case _ => // 不正な計算のため処理なし(0除算とか)
              }
            }
          }
        }
      }
    }
  }
}