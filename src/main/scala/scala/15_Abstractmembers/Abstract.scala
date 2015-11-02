package scalableProgramming.chapter20

/**
 * @author Yuki Yoshikawa
 */
trait Abstract {
	type T
	def transform(x: T): T
	val initial: T
	var current: T
}