package scala.Abstractmembers

abstract class Apple extends Fruit {
	val v: String
	val m: String	// OK : defをvalでオーバーらいづすることは認められる
}