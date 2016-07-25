package element

import composition_inheritance.Element.elem
import org.scalatest.Suite

/** ScalaTestを用いたユニットテスト */
class ElementSuite extends Suite {

  def testUniformElement() {
    val ele = elem('x', 2, 3)
    assert(ele.width == 2)
  }
}