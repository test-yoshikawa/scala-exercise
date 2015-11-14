package scala.Abstractmembers

abstract class BadApple extends Fruit {

//	def v: String	// エラー : valをdefでオーバーライトできない
	def m: String
}