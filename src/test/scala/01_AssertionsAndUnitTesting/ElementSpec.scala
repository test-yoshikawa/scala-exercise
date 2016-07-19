package assertionsandunittesting

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import compositionandinheritance.Element.elem

/**
 * ふるまい駆動開発（behavior-driven developmennt:BDD）のテストスタイル
 *
 */
class ElementSpec extends FlatSpec with ShouldMatchers {
	"A UniformElement" should "have a width equal to the passed value" in {
		val ele = elem('x', 2, 3)
		ele.width should be (2)
	}

	it should "have a height equal to the passed value" in {
		val ele = elem('x', 2, 3)
		ele.height should be (3)
	}

	// 参考書通りに書いてもうまくいかない・・・(涙)=>ArrayIndexOutOfBoundsExceptionに変更
	it should "throws an IAAE if passed a negative width" in {
		evaluating {
			elem('x', -2, -3)
		} should produce [ArrayIndexOutOfBoundsException]
	}
}