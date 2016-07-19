package assertionsandunittesting

import org.scalatest.Suite
import compositionandinheritance.Element.elem

/**
 * ScalaTestを用いたユニットテスト
 */
class ElementSuite extends Suite {

	def testUniformElement() {
		val ele = elem('x', 2, 3)
		assert(ele.width == 2)
	}

}