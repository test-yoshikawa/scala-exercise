package scalableProgramming.chapter20

/**
 * @author Yuki Yoshikawa
 */
abstract class Apple extends Fruit {
	val v: String
	val m: String	// OK : defをvalでオーバーらいづすることは認められる
}