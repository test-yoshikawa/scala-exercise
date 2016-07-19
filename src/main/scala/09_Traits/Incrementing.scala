package traits

/**
 * Queueの要素を+1するTrait
 */
trait Incrementing extends IntQueue {
	abstract override def put(x: Int) { super.put(x + 1) }
}