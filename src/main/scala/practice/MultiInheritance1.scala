package practice

/**************************************
 * "-Xcheckint"オプションをつけることで
 * 未初期化のフィールドは実行例外が発生する
 *************************************/
// trait A1 {
//   val foo: Int

//   // abstractなvalとオーバーライドされたvalは初期化中はデフォルト値
//   // それ以外は指定した値
//   val bar = 10
//   // 初期化中、barには10が代入されるのではなく、デフォルト値である0が代入される
//   println("In A: foo: " + foo + ", bar: " + bar)
// }

// class B1 extends A1 {
//   val foo: Int = 25
//   println("In B: foo: " + foo + ", bar: " + bar)
// }

// class C1 extends B1 {
//   override val bar = 99
//   println("In C: foo " + foo + ", bar: " + bar)
// }

/**************************************
 * "-Xcheckint"オプションをつけた場合
 * ・valをdefに変えることで正常に実行される
 * 　defの処理は基本コンストラクタに属さず、初期化時に実行されないため
 * 　アクセスするたびに式を評価されてしまう
 * 　
 * ・lazy valで宣言することでも、正常に実行される
 * 　欠点あり
 * 　　(1)同期化のため、わずかながらパフォーマンスに影響あり
 * 　　(2)abstract lazy valを宣言することはできない
 * 　　(3)最初のアクセス時にスタックオーバーフローやデットロックを
 * 　　　　 引き起こす可能性がある循環参照が発生しやすい
 * 　　(4)val同士に循環参照がなくても、オブジェクト間で循環参照が
 * 　　　　 あれば、デットロックを引き起こす可能性がある。
 * 　　　　 とても繊細で原因がわかりにくい
 *************************************/
trait A1 {
  lazy val foo: Int = 9
  def bar: Int = 10
  println("In A1: foo: " + foo + ", bar: " + bar)
}

class B1 extends A1 {
  override lazy val foo: Int = 25
  println("In B1: foo: " + foo + ", bar: " + bar)
}

class C1 extends B1 {
  override def bar: Int = 99
  println("In C1: foo: " + foo + ", bar: " + bar)
}

object MultiInheritance1 {
  def main(args: Array[String]): Unit = {
    new C1()
  }
}