package composition_inheritance

import ElementNew.elem

/** 渦巻きを描くオブジェクト */
object Spiral {
  var space = elem(" ")
  var corner = elem("+")

  /** Spiral図をコンソール上で出力する
    *
    * @param nEdges 角の数
    * @param direction 開始方向（0: 上, 1: 右, 2: した）
    * @return Spiral図
    */
  def spiral(nEdges: Int, direction: Int): ElementNew = {
    if (nEdges == 1) elem("+")
    else {
      val sp = spiral(nEdges - 1, (direction + 3) % 4)
      def verticalBar = elem('|', 1, sp.height)
      def horizontalBar = elem('-', sp.width, 1)

      if (direction == 0)
        (corner beside horizontalBar) above (sp beside space)
      else if (direction == 1)
        (sp above space) beside (corner above verticalBar)
      else if (direction == 2)
        (space beside sp) above (horizontalBar beside corner)
      else
        (verticalBar above corner) beside (space above sp)
    }
  }

  /** Spiral実行
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
    val nSides = args(0).toInt
    println(spiral(nSides, 0))
    println()
    println()
    println(spiral(nSides, 1))
    println()
    println()
    println(spiral(nSides, 2))
  }
}