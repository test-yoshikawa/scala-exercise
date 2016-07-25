package element

import composition_inheritance.Element.elem
import org.scalatest.junit.JUnit3Suite

/** JUnit3Suiteを使用したJUnitテストクラス */
class ElementJUnit3Suite extends JUnit3Suite {
  def testUniformElement() {
    val ele = elem('x', 2, 3)
    assert(ele.width === 2)
    expect(3) { ele.height }
    intercept[ArrayIndexOutOfBoundsException] {
      elem('x', -2, -3)
    }
  }
}