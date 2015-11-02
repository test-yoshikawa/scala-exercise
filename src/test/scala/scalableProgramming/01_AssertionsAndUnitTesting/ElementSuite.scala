package scala.AssertionsAndUnitTesting

import org.scalatest.Suite
import scala.CompositionAndInheritance.Element.elem

/**
 * Suiteを使用したテストクラス
 *
 * @author Yuki Yoshikawa
 */
class ElementSuite extends Suite {

	def testUniformElement() {
		val ele = elem('x', 2, 3)
		assert(ele.width == 2)
	}

}