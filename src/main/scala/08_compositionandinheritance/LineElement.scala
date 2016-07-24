package compositionandinheritance

/** ArrayElementを拡張 */
class LineElement(s: String) extends ArrayElement(Array(s)) { // スーパーコンストラクタの呼び出し
  override val width = s.length

  override val height = 1

  /** デモ */
  override def demo() {
    println("LineElement's implementation invoked")
  }
}