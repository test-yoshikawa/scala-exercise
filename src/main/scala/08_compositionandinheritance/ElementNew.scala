package compositionandinheritance

/** レイアウト要素を表現するオブジェクト */
object ElementNew {
  // 非公開クラスの実装の隠ぺい
  private class ArrayElementHidden(val contents: Array[String]) extends ElementNew

  private class LineElementHidden(s: String, override val height: Int) extends ElementNew {
    def contents = Array(s)
    override val width = s.length
    // override val height = 1 // -Xcheckinitオプションつけると実行時例外が発生するので、コンストラクタで設定させる
  }

  private class UniformElementHidden(ch: Char, override val width: Int, override val height: Int) extends ElementNew {
    def contents = Array.fill(height)(ch.toString * width)
  }

  /** ファクトリーメソッド
    *
    * @param contents Array[String]
    * @return ElementNew(ArrayElementHidden)
    */
  def elem(contents: Array[String]): ElementNew = new ArrayElementHidden(contents)

  /** ファクトリーメソッド
    *
    * @param line String
    * @return ElementNew(LineElementHidden)
    */
  def elem(line: String): ElementNew = new LineElementHidden(line, 1)

  /** ファクトリーメソッド
    *
    * @param ch Char
    * @param width Int
    * @param height Int
    * @return ElementNew(UniformElementHidden)
    */
  def elem(ch: Char, width: Int, height: Int): ElementNew = new UniformElementHidden(ch, width, height)
}


/** レイアウト要素を表現する抽象クラス */
import ElementNew.elem
abstract class ElementNew {
  def contents: Array[String]

  // height、widthはdefで定義手もよいはvalのほうがわずかだが速い
  // クラスが初期化されるときに先に計算されているため
  val height = contents.length
  val width = if (height == 0) 0 else contents(0).length

  /** デモ */
  def demo() {
    println("Elements's implementation invoked")
  }

  /** 2つのcontentsを連結する（Array("a", "b") beside Array("c", "d") => Array("a", "b", "c", "d")）
    *
    * @param that ElementNew
    * @return 連結したElement
    */
  def above(that: ElementNew): ElementNew = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    elem(this1.contents ++ that1.contents)
  }

  /** ２つのcontentsを横に並べる（Array("a", "b") beside Array("c", "d") => Array("a", "c", "b", "d")）
    *
    * @param that ElementNew
    * @return 要素を並べたElement
    */
  def beside(that: ElementNew): ElementNew = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    // 命令型スタイル
    //		for (i <- 0 until this.contents.length) {
    //			contents(i) = this.contents(i) + that.contents(i)
    //		}
    elem(for ((line1, line2) <- this1.contents zip that1.contents) yield line1 + line2)
  }

  /** 同じ幅になるように調整する
    *
    * @param w 調整したい幅
    * @return 調整したElement
    */
  def widen(w:Int): ElementNew = {
    if (w <= height) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right
    }
  }

  /** 同じ高さになるように調整する
    *
    * @param h 調整したい高さ
    * @return 調整したElement
    */
  def heighten(h: Int): ElementNew = {
    if (h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }
  }

  override def toString = contents mkString "\n"
}