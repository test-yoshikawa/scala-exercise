package scalableProgramming.chapter14

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import scalableProgramming.chapter10.Element.elem

/**
 * ふるまい駆動開発（behavior-driven developmennt:BDD）のテストスタイル
 *
 * @author Yuki Yoshikawa
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

	// うまくいかない・・・(涙)
	it should "throws an IAAE if passed a negative width" in {
		evaluating {
			elem('x', -2, 3)
		} should produce [IllegalArgumentException]
	}
}