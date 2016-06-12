package basic.abstractmembers

abstract class BadApple extends Fruit {

//	def v: String	// エラー : valをdefでオーバーライトできない
	def m: String
}