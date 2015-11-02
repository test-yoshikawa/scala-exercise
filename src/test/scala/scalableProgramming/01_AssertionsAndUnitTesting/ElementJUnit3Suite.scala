package scala.AssertionsAndUnitTesting

import org.scalatest.junit.JUnit3Suite
import scala.CompositionAndInheritance.Element.elem

/**
 * JUnit3Suiteを使用したJUnitテストクラス
 *
 * @author Yuki Yoshikawa
 */
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