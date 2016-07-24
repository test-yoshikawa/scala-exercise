package traits

import scala.collection.mutable.ArrayBuffer

/** 数値型のQueue */
class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]

  /** 要素を取り出す
    *
    * @return Int
    */
  def get() = buf.remove(0)

  /** 要素を格納する
    *
    * @param x Int
    */
  def put(x: Int) { buf += x }
}