package scala.Abstractmembers

/**
 * Abstractトレイトの実装（抽象メンバーの定義を一つ一つ埋めていかなければならない）
 *
 */
class Concrete extends Abstract {
  type T = String
	def transform(x: String) = x + x
	val initial = "hi"
	var current = initial
}