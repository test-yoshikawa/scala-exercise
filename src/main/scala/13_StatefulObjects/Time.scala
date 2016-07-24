package statefulobjects

/** 時間を扱うクラス */
class Time {
  private[this] var h = 12	// 暗黙的にgetter/setterメソッドが定義されている
  private[this] var m = 0

  // getter/setterメソッドの定義（独自の処理を追加しない場合は記述する必要なし）
  /** Hourの取得
    *
    * @return
    */
  def hour: Int = h

  /** Hourの設定
    *
    * @param x Int
    */
  def hour_= (x: Int) {
    require(0 <= x && x < 24)
    h = x
  }

  /** Minuteの取得
    *
    * @return
    */
  def minute: Int = m

  /** Minuteの設定
    *
    * @param x
    */
  def minute_= (x: Int) {
    require(0 <= x && x < 60)
    m = x
  }
}