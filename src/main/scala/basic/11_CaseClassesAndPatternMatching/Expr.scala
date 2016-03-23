package basic.caseclassandpatternmatching

/**
 * 変数、数値、単項・二項演算から構成される算術式抽象クラス
 */
sealed abstract class Expr

// ケースクラス
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

/**
 * 算術式を扱うコンパニオンオブジェクト
 */
object Expr {

	/**
	 * コンストラクタパターン
	 */
	def simplifyTop(expr: Expr): Expr = expr match {
		case UnOp("-", UnOp("-", e)) => e // 負の負は元のまま
		case BinOp("+", e, Number(0)) => e // 0の加算は元のまま
		case BinOp("*", e, Number(1)) => e // 1の乗算は元のまま
		case BinOp(_, _, _) => expr // _:ワイルドカードパターン
		case _ => expr
	}

	/**
	 * 定数パターンを使ったパターンマッチ
	 */
	def describe(x: Any) = x match {
		case 5 => "five"
		case true => "truth"
		case "hello" => "hi!"
		case Nil => "hte empty list"
		case _ => "something else"
	}

	/**
	 * 変数を使用したパターンマッチ
	 */
	def variable(value: Any) = value match {
		case 0 => "zero"
		case value => "not zero: " + value
	}

	/**
	 * 固定長のシーケンスパターンマッチ
	 */
	def sequenceFixed(expr: Any) = expr match {
		case List(0, _, _) => println("found it")
		case _ => println("no match")
	}

	/**
	 * 可変長のシーケンスパターンマッチ
	 */
	def sequenceVariable(expr: Any) = expr match {
		case List(0, _*) => println("found it")
		case _ => println("no match")
	}

	/**
	 * タプルパターンマッチ
	 */
	def tupleDemo(expr: Any) = expr match {
		case (a, b, c) => println("matched " + a + ". " + b + ", " + c)
		case _ => println("no match")
	}

	/**
	 * 型付きパターンマッチ（長さを取得する）
	 */
	def generalSize(x: Any) = x match {
		case s: String => s.length
		case m: Map[_, _] => m.size
		case _ => -1
	}

	/**
	 * @ 記号を使用した変数束縛を行うパターンマッチ
	 */
	def boundVariable(expr: Any) = expr match {
		case UnOp("abs", e @ UnOp("abs", _)) => e	// UnOp("abs", _)にマッチした部分がe変数として式の中で使用できる
		case _ =>
	}

	/**
	 * パターンガードを持つマッチパターン
	 */
	def simplifyAdd(expr: Expr) = expr match {
		case BinOp("*", x, y) if x == y => BinOp("*", x, Number(2))
		case _ => expr
	}

	/**
	 * ケースの順序が意味をもつパターンマッチ
	 */
	def simplifyAll(expr: Expr): Expr = expr match {
		case UnOp("-", UnOp("-", e)) => simplifyAll(e)	// '-' は元の数の逆元
		case BinOp("+", e, Number(0)) => simplifyAll(e)		// '0'は'+'の単位元
		case BinOp("*", e, Number(1)) => simplifyAll(e)		// '1'は'*'の単位元
		case UnOp(op, e) => UnOp(op, simplifyAll(e))
		case BinOp(op, l, r) => BinOp(op, simplifyAll(l), simplifyAll(r))
		case _ => expr
	}
}