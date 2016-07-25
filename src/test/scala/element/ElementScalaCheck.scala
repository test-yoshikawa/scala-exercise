package element

import composition_inheritance.Element.elem
import org.scalacheck.Prop._
import org.scalatest.WordSpec
import org.scalatest.prop.Checkers

/** ScalaCheckを用いたユニットテスト */
class ElementScalaCheck extends WordSpec with Checkers {
  // implicit override val generatorDrivenConfig =
  // PropertyCheckConfig(minSize = 10, maxSize = 20)

  "elem result" must {
    "have passed width" in {
      check((w: Int) => w > 0 ==> (elem('x', w, 3).width == w))
    }

    "have passed height" in {
      check((h: Int) => h > 0 ==> (elem('x', 2, h).height == h))
    }
  }
}