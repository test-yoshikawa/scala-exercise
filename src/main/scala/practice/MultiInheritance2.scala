package practice

/**
 * 事前初期化フィールドを使うことで、正常に実行される
 */
trait A2 {
  val foo: Int
  val bar = 10
  println("In A2: foo: " + foo + ", bar: " + bar)
}

class B2 extends {
  // Traitで初期化されていない場合はオーバーライドする
  override val foo = 25
} with A2 {
  println("In B2: foo: " + foo + ", bar: " + bar)
}

class C2 extends {
  override val foo = 10
  override val bar = 99
} with B2 {
  println("In C2: foo: " + foo + ", bar: " + bar)
}

object MultiInheritance2 {
  def main(args: Array[String]): Unit = {
    new C2()
  }
}