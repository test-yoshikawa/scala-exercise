package basic.AssertionsAndUnitTesting

import org.scalatest.FunSuite
import basic.CompositionAndInheritance.Element.elem

/**
 * ScalaTestを用いたユニットテスト
 */
class ElementFunSuite extends FunSuite {

	test("elem result should have passed width") {
		val ele = elem('x', 3, 3)
		assert(ele.width === 3)
		expect(3){
			ele.width
		}
	}

	test("Intercept test") {
		// 予想通りの例外を投げたかどうかのチェック
		intercept[ArrayIndexOutOfBoundsException] {
			elem('x', -2, -3)
		}
	}
}