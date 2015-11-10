package scala.ClassesAndObjects

import scala.collection.mutable.Map

/**
 * クラス（同名のオブジェクトが存在する場合は「コンパニオンオブジェクト」と呼ぶ）
 *
 */
class ChecksumAccumlator {
	private var sum = 0	// アクセス修飾子を指定しなければpublicになる

	def add(b: Byte) { sum += b }	// 引数はval

	def checksum(): Int = ~(sum & 0xFF) + 1	//~:ビット反転
}

/**
 * シングルトンオブジェクト（同じソースファイル内に定義する）
 *
 * @author Yuki Yoshikawa
 */
object ChecksumAccumlator {
	private val cache = Map[String, Int]()
	def calculate(s: String): Int =
		if (cache.contains(s)) {
			println("get from cache!")
			cache(s)
		} else {
			val acc = new ChecksumAccumlator
			for (c <- s)
				acc.add(c.toByte)
			val cs = acc.checksum()
			cache += (s -> cs)
			cs
		}
}