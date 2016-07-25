package element

import composition_inheritance.Element.elem
import org.scalatest._

/** ふるまい駆動開発（behavior-driven development:BDD）のテストスタイル
  *
  * ShouldMatchersトレイトは非推奨なため実行できない
  *
  * ＝＞「Unfortunately Suite has been deprecated as a style trait. Please use trait Spec instead.」
  *
  */
class ElementSpec extends FlatSpec with Matchers {
  "A UniformElement" should "have a width equal to the passed value" in {
    val ele = elem('x', 2, 3)
    ele.width should be (2)
  }

  it should "have a height equal to the passed value" in {
    val ele = elem('x', 2, 3)
    ele.height should be (3)
  }

  // 参考書通りに書いてもうまくいかない=> 非推奨
  it should "throws an IAAE if passed a negative width" in {
    evaluating {
      elem('x', -2, -3)
    } should produce [ArrayIndexOutOfBoundsException]
  }
}