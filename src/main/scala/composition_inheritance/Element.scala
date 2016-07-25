package composition_inheritance

/** レイアウト要素を表現するオブジェクト */
object Element {
  /** ファクトリーメソッド
    *
    * @param contents Array[String]
    * @return Element
    */
  def elem(contents: Array[String]): Element = new ArrayElement(contents)

  /** ファクトリーメソッド
    *
    * @param line String
    * @return Element
    */
  def elem(line: String): Element = new LineElement(line)

  /** ファクトリーメソッド
    *
    * @param ch Char
    * @param width Int
    * @param height Int
    * @return Element
    */
  def elem(ch: Char, width: Int, height: Int): Element = new UniformElement(ch, width, height)
}

/**
 * レイアウト要素を表現する抽象クラス
 */
import Element.elem
abstract class Element {
  def contents: Array[String]

  // height、widthはdefで定義よりかはvalのほうがわずかだが速い
  // クラスが初期化されるときに先に計算されているため
  val height = contents.length
  val width = if (height == 0) 0 else contents(0).length

  /** デモ */
  def demo() {
    println("Elements's implementation invoked")
  }

  /** 2つのcontentsを連結する（Array("a", "b") beside Array("c", "d") => Array("a", "b", "c", "d")）
    *
    * @param that Element
    * @return 連結したElement
    */
  def above(that: Element): Element = {
    elem(this.contents ++ that.contents)
  }

  /** ２つのcontentsを横に並べる（Array("a", "b") beside Array("c", "d") => Array("a", "c", "b", "d")）
    *
    * @param that Element
    * @return 連結したElement
    */
  def beside(that: Element): Element = {
    val contents = new Array[String](this.contents.length)
    // 命令型スタイル
//    for (i <- 0 until this.contents.length) {
//      contents(i) = this.contents(i) + that.contents(i)
//    }
    elem(for ((line1, line2) <- this.contents zip that.contents) yield line1 + line2)
  }

  override def toString = contents mkString "\n"
}