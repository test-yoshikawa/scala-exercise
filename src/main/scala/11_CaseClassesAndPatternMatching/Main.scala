package caseclassandpatternmatching

import caseclassandpatternmatching.Expr._

/** ケースクラスとパターンマッチ サンプル実行用 */
object Main {

  /** メイン実行
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
    // ケースクラスのサンプルコード
    println("==== Case class sample ====")
    val v = Var("x")
    println("<Var> name : " + v.name)
    val op = BinOp("+", Number(1), v)
    println("<BinOp> operator : " + op.operator + ", left : " + op.left + ", right : " + op.right)

    val opCopy = op.copy(operator = "-")
    println("<copied BinOp> operator : " + opCopy.operator + ", left : " + opCopy.left + ", right : " + opCopy.right)

    // コンストラクタパターンマッチ
    println("\n==== Pattern Match Constructor ====")
    val expr1 = UnOp("-", UnOp("-", Var("x")))
    println(simplifyTop(expr1))

    // 定数パターンを使ったパターンマッチ
    println("\n==== Pattern Match Constant ====")
    println(describe(5))
    println(describe(true))
    println(describe("hello"))
    println(describe(Nil))
    println(describe(expr1))

    // 変数パターンを使ったパターンマッチ
    println("\n==== Pattern Match Variable ====")
    println(variable(0))
    println(variable(2))
    println(variable(expr1))
    println(variable(Nil))

    // 固定長のシーケンスパターンマッチ
    println("\n==== Pattern match fixed Sequence ====")
    sequenceFixed(List(0))
    sequenceFixed(List(0, 1))
    sequenceFixed(List(0, 1, 2))

    // 可変長のシーケンスパターンマッチ
    println("\n==== Pattern match variable Sequence ====")
    sequenceVariable(List(1, 1))
    sequenceVariable(List(0, 1))
    sequenceVariable(List(0, 1, 2))

    // タプルパターンマッチ
    println("\n==== Pattern match Tuple ====")
    tupleDemo(("a", 3, "-tuple"))

    // 型付きパターンマッチ
    val s = "pattern match"
    val m = Map("1"-> "pattern", "2" -> "match")
    println("\n==== Typed pattern match ( get length ) ====")
    println(generalSize(s))
    println(generalSize(m))
    println(generalSize(List(1, 3, 4)))


    // @ 記号を使用した変数束縛を行うパターンマッチ
    println("\n==== Pattern match used by variable-binding ====")
    println(boundVariable(UnOp("abs", UnOp("abs", Var("x")))))

    // パターンガードを持つマッチパターン
    println("\n==== Pattern match used by pattern guard ====")
    println(simplifyAdd(BinOp("*", Number(1), Number(1))))
    println(simplifyAdd(BinOp("*", Number(2), Number(1))))

    // ケースの順序が意味を持つパターンマッチ
    println("\n==== Pattern match meaning sequence of case ====")
    println("BinOp(\"*\", Number(1), Number(1)) => " + simplifyAll(BinOp("*", Number(1), Number(1))))
    println("BinOp(\"+\", Number(10), Number(0)) => " + simplifyAll(BinOp("+", Number(10), Number(0))))
    println("UnOp(\"+\", BinOp(\"+\", Number(10), Number(0))) => " +
        simplifyAll(UnOp("+", BinOp("+", Number(10), Number(0)))))
    println("BinOp(\"+\", BinOp(\"+\", Number(10), Number(0)), BinOp(\"*\", Number(1), Number(1))) => " +
        simplifyAll(BinOp("+", BinOp("+", Number(10), Number(0)), BinOp("*", Number(1), Number(1)))))

    // 1つの代入で複数の変数を定義する
    println("\n==== Define multiple variable by substitute one ====")
    val myTuple = (123, "abc")
    val (number, string) = myTuple
    println("myTuple: " + myTuple + " => number: " + number + ", string: " + string)
    val exp = new BinOp("*", Number(5.0), Number(1.0))
    val BinOp(op1, left, right) = exp
    println("exp: " + exp + " => op1: " + op1 + ", left: " + left + ", right: " + right)
  }
}