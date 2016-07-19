package abstractmembers

/**
 * Abstractトレイトの実装
 * 	抽象メンバーの定義を一つ一つ埋めていかなければならない
 *
 */
class Concrete extends Abstract {
  type T = String		// 抽象型の定義
	def transform(x: String) = x + x
	val initial = "hi"
	var current = initial
}