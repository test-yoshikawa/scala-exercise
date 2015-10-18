package scalableProgramming.chapter20

/**
 * @author Yuki Yoshikawa
 */
abstract class BadApple extends Fruit {

//	def v: String	// エラー : valをdefでオーバーライトできない
	def m: String
}