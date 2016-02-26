package practice

/**
 * 初期化順による潜在的な問題に対処するための方法はユースケースに依存する。
 * ・アクセスするたびに式を評価しても性能的に問題なければdefで定義してもかまわない
 * ・循環参照を避けた実装であればlazy valがユーザにとって最もシンプルな方法
 * ・上記以外の場合は事前フィールド定義を使えるが、
 * 　通常のabstractフィールドが良い選択になるかもらしい（確かにわかりやすい）
 */
abstract class A3 {
  type T
  val foo: T
}

class B3 extends A3 {
  type T = Int
  val foo = 25
  println("In B2: foo: " + foo)
}

class C3 extends B3 {
  val bar = 99
  println("In C2: foo: " + foo + ", bar: " + bar)
}

object MultiInheritance3 {
  def main(args: Array[String]): Unit = {
    new C3()
  }
}