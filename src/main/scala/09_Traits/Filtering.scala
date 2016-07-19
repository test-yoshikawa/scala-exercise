package traits

/**
 * Filter(=負の数値は除く)が設定されたTrait
 */
trait Filtering extends IntQueue {
	abstract override def put(x: Int) {
		if (x >= 0) super.put(x)
	}
}