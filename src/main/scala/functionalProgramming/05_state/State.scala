package functionalProgramming

trait RNG {
	def nextInt: (Int, RNG)
}

case class SimpleRNG(seed: Long) extends RNG {
	def nextInt: (Int, RNG) = {
		// &はビット論理積。現在のシードを使って新しいシードを生成
		val newSeed = (seed * 0x5DEEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL
		// 次の状態を作成
		val nextRNG = SimpleRNG(newSeed)
		// >>>は0埋めバイナリシフト。nは疑似乱数（整数）
		val n = (newSeed >>> 16).toInt
		(n, nextRNG)
	}
}