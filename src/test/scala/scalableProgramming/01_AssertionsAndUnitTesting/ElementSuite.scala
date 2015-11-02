package scalableProgramming.chapter14

import org.scalatest.Suite
import scalableProgramming.chapter10.Element.elem

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