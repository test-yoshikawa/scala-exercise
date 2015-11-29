package StatefulObjects

/**
 * 時間を扱うクラス
 */
class Time {
	private[this] var h = 12	// 暗黙的にgetter/setterメソッドが定義されている
	private[this] var m = 0

	// getterr/setterメソッドの定義（独自の処理を追加しない場合は記述する必要なし）
	def hour: Int = h
	def hour_= (x: Int) {
		require(0 <= x && x < 24)
		h = x
	}
	def minute: Int = m
	def minute_= (x: Int) {
		require(0 <= x && x < 60)
		m = x
	}
}