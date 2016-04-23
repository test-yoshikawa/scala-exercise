package basic.classandobject

import scala.collection.mutable.Map

/**
 * クラス
 * ※同名のオブジェクトが存在する場合は「コンパニオンクラス」と呼ぶ
 *
 */
class CheckSumAccumlator {
	private var sum = 0	// アクセス修飾子を指定しなければpublicになる

	def add(b: Byte) { sum += b }	// 引数はval

	def checksum(): Int = ~(sum & 0xFF) + 1	//~:ビット反転
}

/**
 * シングルトンオブジェクト
 * ※同名のクラスが存在する場合は「コンパニオンオブジェクト」と呼ぶ（互いに非公開メンバーにアクセスできる）
 * ※同じソースファイル内に定義する
 *
 */
object CheckSumAccumlator {
	private val cache = Map[String, Int]()
	def calculate(s: String): Int =
		if (cache.contains(s)) {
			println("get from cache!")
			cache(s)
		} else {
			val acc = new CheckSumAccumlator
			for (c <- s)
				acc.add(c.toByte)
			val cs = acc.checksum()
			cache += (s -> cs)
			cs
		}
}