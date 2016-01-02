package basic.AbstractMembers

/**
 * Abstract Trait
 * 抽象メンバーの定義（完全に定義されていない）
 */
trait Abstract {
	type T
	def transform(x: T): T
	val initial: T
	var current: T
}