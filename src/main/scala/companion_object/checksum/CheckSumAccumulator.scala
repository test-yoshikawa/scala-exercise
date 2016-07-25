package companion_object.checksum

import scala.collection.mutable.Map

/**
  * ビット操作クラス
  */
class CheckSumAccumulator {
  private var sum = 0	// アクセス修飾子を指定しなければpublicになる

  /** フィールドsumに引数を足す
    *
    * @param b バイト
    */
  def add(b: Byte) { sum += b }	// 引数はval

  /** フィールドsumをビット反転した値を返す
    *
    * @return ビット反転した値
    */
  def checksum(): Int = ~(sum & 0xFF) + 1	//~:ビット反転
}

/** シングルトンオブジェクト
  *
  * - 同名のクラスが存在する場合は「コンパニオンオブジェクト」と呼ぶ（互いに非公開メンバーにアクセスできる）
  *
  * - 同じソースファイル内に定義する
  *
  */
object CheckSumAccumulator {
	private val cache = Map[String, Int]()

  /** 文字列をバイトに計算する
    *
    * - 計算結果をキャッシュする
    *
    * @param s String
    * @return
    */
  def calculate(s: String): Int =
    if (cache.contains(s)) {
      println("get from cache!")
      cache(s)
    } else {
      val acc = new CheckSumAccumulator
      for (c <- s) acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
}