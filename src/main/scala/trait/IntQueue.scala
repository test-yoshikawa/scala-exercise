package traits

/** 数値型Queueの抽象クラス */
abstract class IntQueue {

  /** 要素の取得
    *
    * @return
    */
  def get(): Int

  /** 要素の格納
    *
    * @param x Int
    */
  def put(x: Int)
}