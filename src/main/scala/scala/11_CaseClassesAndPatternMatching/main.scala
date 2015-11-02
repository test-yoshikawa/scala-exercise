package scalableProgramming.chapter15

import scalableProgramming.chapter15.Expr._


/**
 * @author Yuki Yoshikawa
 */
object main {

	def main(args: Array[String]) {

		// ケースクラスのサンプルコード
		println("==== ケースクラスのサンプルコード ====")
		val v = Var("x")
		println("<Var> name : " + v.name)
		val op = BinOp("+", Number(1), v)
		println("<BinOp> operator : " + op.operator + ", left : " + op.left + ", right : " + op.right)

		val opCopy = op.copy(operator = "-")
		println("<copied BinOp> operator : " + opCopy.operator + ", left : " + opCopy.left + ", right : " + opCopy.right)

		// コンストラクタパターンマッチ
		println()
		println("==== コンストラクタパターンマッチ ====")
		val expr1 = UnOp("-", UnOp("-", Var("x")))
		println(simplifyTop(expr1))

		// 定数パターンを使ったパターンマッチ
		println()
		println("==== 定数パターンを使ったパターンマッチ ====")
		println(describe(5))
		println(describe(true))
		println(describe("hello"))
		println(describe(Nil))
		println(describe(expr1))

		// 変数パターンを使ったパターンマッチ
		println()
		println("==== 変数パターンを使ったパターンマッチ ====")
		println(variable(0))
		println(variable(2))
		println(variable(expr1))
		println(variable(Nil))

		// 固定長のシーケンスパターンマッチ
		println()
		println("==== 固定長のシーケンスパターンマッチ ====")
		println(sequenceFixed(List(0)))
		println(sequenceFixed(List(0, 1)))
		println(sequenceFixed(List(0, 1, 2)))

		// 可変長のシーケンスパターンマッチ
		println()
		println("==== 可変長のシーケンスパターンマッチ ====")
		println(sequenceVariable(List(0)))
		println(sequenceVariable(List(0, 1)))
		println(sequenceVariable(List(0, 1, 2)))

		// タプルパターンマッチ
		println()
		println("==== タプルパターンマッチ ====")
		println(tupleDemo(("a", 3, "-tuple")))

		// 型付きパターンマッチ
		val s = "pattern match"
		val m = Map("1"-> "pattern", "2" -> "match")
		println()
		println("==== 型付きパターンマッチ（長さを取得する） ====")
		println(generalSize(s))
		println(generalSize(m))
		println(generalSize(List(1, 3, 4)))


		// @ 記号を使用した変数束縛を行うパターンマッチ
		println()
		println("==== @記号を使用した変数束縛を行うパターンマッチ ====")
		println(boundVariable(UnOp("abs", UnOp("abs", Var("x")))))

		// パターンガードを持つマッチパターン
		println()
		println("==== パターンガードを持つマッチパターン ====")
		println(simplifyAdd(BinOp("*", Number(1), Number(1))))
		println(simplifyAdd(BinOp("*", Number(2), Number(1))))

		// ケースの順序が意味を持つパターンマッチ
		println()
		println("==== ケースの順序が意味を持つパターンマッチ ====")
		println("BinOp(\"*\", Number(1), Number(1)) => " + simplifyAll(BinOp("*", Number(1), Number(1))))
		println("BinOp(\"+\", Number(10), Number(0)) => " + simplifyAll(BinOp("+", Number(10), Number(0))))
		println("UnOp(\"+\", BinOp(\"+\", Number(10), Number(0))) => " +
				simplifyAll(UnOp("+", BinOp("+", Number(10), Number(0)))))
		println("BinOp(\"+\", BinOp(\"+\", Number(10), Number(0)), BinOp(\"*\", Number(1), Number(1))) => " +
				simplifyAll(BinOp("+", BinOp("+", Number(10), Number(0)), BinOp("*", Number(1), Number(1)))))

		// 1つの代入で複数の変数を定義する
		println()
		println("==== 1つの代入で複数の変数を定義する ====")
		val myTuple = (123, "abc")
		val (number, string) = myTuple
		println("myTuple: " + myTuple + " => number: " + number + ", string: " + string)
		val exp = new BinOp("*", Number(5.0), Number(1.0))
		val BinOp(op1, left, right) = exp
		println("exp: " + exp + " => op1: " + op1 + ", left: " + left + ", right: " + right)



	}
}