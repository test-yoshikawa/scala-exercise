package basic.traits

/**
 * 数値型Queueの抽象クラス
 */
abstract class IntQueue {
	def get(): Int
	def put(x: Int)
}