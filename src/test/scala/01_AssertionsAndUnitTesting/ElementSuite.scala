package AssertionsAndUnitTesting

import org.scalatest.Suite
import CompositionAndInheritance.Element.elem

/**
 * ScalaTestを用いたユニットテスト
 */
class ElementSuite extends Suite {

	def testUniformElement() {
		val ele = elem('x', 2, 3)
		assert(ele.width == 2)
	}

}