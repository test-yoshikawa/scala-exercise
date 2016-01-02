package basic.Traits

/**
 * Queueの要素を2倍にするTrait
 */
trait Doubling extends IntQueue {
	abstract override def put(x: Int) { super.put(2 * x) }
}