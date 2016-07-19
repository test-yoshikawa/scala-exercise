package assertionsandunittesting

import org.scalatest.WordSpec
import org.scalatest.prop.Checkers
import org.scalacheck.Prop._
import compositionandinheritance.Element.elem

/**
 * ScalaCheckを用いたユニットテスト
 */
class ElementScalaCheck extends WordSpec with Checkers {
	// implicit override val generatorDrivenConfig =
	// 	PropertyCheckConfig(minSize = 10, maxSize = 20)

	"elem result" must {
		"have passed width" in {
			check((w: Int) => w > 0 ==> (elem('x', w, 3).width == w))
		}

		"have passed height" in {
			check((h: Int) => h > 0 ==> (elem('x', 2, h).height == h))
		}

	}
}