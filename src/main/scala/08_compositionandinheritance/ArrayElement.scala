package compositionandinheritance

/** レイアウト要素を扱うクラス（配列版） */
class ArrayElement(val contents: Array[String]) extends Element {
  // 不要な冗長性のあるコード⇒↑のようにパラメータフィールドとしてcontentsを定義する
  // パラメータにvalをつけた場合はパラメータとフィールドを同時に定義する略記法。クラス外からアクセスできる
  // val contents = conts

  /** デモ */
  override def demo() {
    // final修飾子を付けるとサブクラスでオーバーライドできなくなる
    // final override def demo() { …
    println("ArrayElement's implementation invoked")
  }
}