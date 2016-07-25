package type_parameter

/** Queueの基本形 */
class QueueBasic[+T] private (private[this] var leading: List[T], private[this] var trailing: List[T]) {

  /** mirror */
  private def mirror() = if (leading.isEmpty) {
    while(!trailing.isEmpty) {
      leading = trailing.head :: leading
      trailing = trailing.tail
    }
  }

  /** Queueの先頭を取得する
    *
    * @return T
    */
  def head: T = {
    mirror()
    leading.head
  }

  /** Queueの末尾を取得する
    *
    * @return T
    */
  def tail: QueueBasic[T] = {
    mirror()
    new QueueBasic(leading.tail, trailing)
  }

  /** Queueを追加する
    *
    * @param x
    * @tparam U
    * @return enqueueしたQueue
    */
  def enqueue[U >: T](x: U) = new QueueBasic(leading, x :: trailing)
}