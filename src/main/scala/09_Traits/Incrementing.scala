package traits

/** Queueの要素を+1するTrait */
trait Incrementing extends IntQueue {

  /** 要素の格納
    *
    * @param x Int
    */
  abstract override def put(x: Int) { super.put(x + 1) }
}