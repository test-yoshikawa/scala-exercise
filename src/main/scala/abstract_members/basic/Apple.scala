package abstract_members.basic

/** Apple抽象クラス */
abstract class Apple extends Fruit {
  val v: String
  val m: String	// OK : defをvalでオーバーライドすることは認められる
}