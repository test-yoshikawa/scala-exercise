package scalableProgramming.chapter12

/**
 * @author Yuki Yoshikawa
 */
trait Filtering extends IntQueue {
	abstract override def put(x: Int) {
		if (x >= 0) super.put(x)
	}
}