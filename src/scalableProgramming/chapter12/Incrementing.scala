package scalableProgramming.chapter12

/**
 * @author Yuki Yoshikawa
 */
trait Incrementing extends IntQueue {
	abstract override def put(x: Int) { super.put(x + 1) }
}