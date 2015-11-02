package scalableProgramming.chapter14

import junit.framework.TestCase
import junit.framework.Assert.assertEquals
import junit.framework.Assert.fail
import scalableProgramming.chapter10.Element.elem

/**
 * JUnitを使用したテストクラス
 *
 * @author Yuki Yoshikawa
 */
class ElementTestCase extends TestCase {

	def testUniormElement() {
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