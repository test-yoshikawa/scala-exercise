package element

import composition_inheritance.Element.elem
import junit.framework.Assert.{assertEquals, fail}
import junit.framework.TestCase

/** JUnitを使用したユニットテスト */
class ElementTestCase extends TestCase {

  def testUniformElement() {
    val ele = elem('x', 2, 3)
    assertEquals(2, ele.width)
    assertEquals(3, ele.height)
    try {
      elem('x', -2, 3)
      fail()
    } catch {
      case e: IllegalArgumentException => println("catch : IllegalArgumentException")
    }
  }
}