package functionalProgramming

// Aという方でパラメータ化されたListデータ型
sealed trait List[+A]
// 空のリストを表すデータコンストラクタ
case object Nil extends List[Nothing]
// 空でないリストを表すデータコンストラクタ
// tailもList[A]であり、Nilまたは別のConsになる場合があることに注意
case class Cons[+A](head: A, tail: List[A]) extends List[A]

/**
 * リストコンパニオンオブジェクト
 */
object List {

	def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = as match {
		case Nil => z
		case Cons(x, xs) => f(x, foldRight(xs, z)(f))
	}

  def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil => z
    case Cons(x,xs) => foldLeft(xs, f(z,x))(f)
  }

	/**
	 * パターンマッチングを使って整数のリストを足し合わせる関数
	 */
	def sum(ints: List[Int]): Int = ints match {
		case Nil => 0											// 空のリストの合計は0
		case Cons(x, xs) => x + sum(xs)		// xから始まるリストの合計は、xにリストの残りの合計を足したもの
	}
	def sumViaFoldRight(ints: List[Int]): Int = foldRight(ints, 0)((x, y) => x + y)
	def sumViaFoldLeft(ints: List[Int]): Int = foldLeft(ints, 0)((x, y) => x + y)

	/**
	 * パターンマッチングを使って数値のリストをかけ合わせる関数
	 */
	def product(ds: List[Double]): Double = ds match {
			case Nil => 1.0
			case Cons(0.0, _) => 0.0
			case Cons(x, xs) => x * product(xs)
	} 
	def productViaFoldRight(ds: List[Double]): Double = foldRight(ds, 1.0)(_ * _)
	def productViaFoldLeft(ds: List[Double]): Double = foldLeft(ds, 1.0)(_ * _)

	/**
	 * リストの長さを返す関数
	 */
	def length[A](as: List[A]): Int = as match {
		case Nil => 0
		case Cons(x, xs) => 1 + length(xs)
	}
	def lengthViaFoldRight[A](as: List[A]): Int = foldRight(as, 0)((x, y) => 1 + y)
	def lengthViaFoldLeft[A](as: List[A]): Int = foldLeft(as, 0)((x, y) => 1 + x)

	/**
	 * リストに追加をする関数
	 * foldLeftをベースに作成すると
	 * 「case Cons(x,xs) => foldLeft(xs, f(z,x))(f)」でtype mismatchが発生する
	 */
	def appendViaFoldRight[A](l: List[A], r: List[A]): List[A] = foldRight(l, r)(Cons(_,_))

	/**
	 * 適用関数
	 */
	def apply[A](as: A*): List[A] = 
		if (as.isEmpty) Nil
		else Cons(as.head, apply(as.tail: _*))

	/**
	 * Listを文字列に変換する関数
	 */
	def mkString[A](as: List[A], split: String): String = as match {
		case Cons(x, Nil) => x.toString
		case Cons(x, y) => x + split + mkString(y, split)
		case _ => ""
	}

	/**
	 * 先頭要素を取り除いたリストを返す関数
	 */
	def tail[A](list: List[A]): List[A] = list match {
		case Cons(x, y) => y
		case _ => list
	}

	/**
	 * 先頭要素を指定した値と置き換えるリストを返す関数
	 */
	def setHead[A](list: List[A], set: A): List[A] = list match {
		case Cons(x, y) => Cons(set, y)
		case _ => list
	}

	/**
	 * 先頭からN個の要素を削除する関数
	 */
	def drop[A](list: List[A], n: Int): List[A] = list match {
		case Cons(x, y) if (n > 0) => drop(y, n-1)
		case _ => list
	}

	/**
	 * 述語とマッチする場合に限り削除する関数
	 */
	def dropWhile[A](list: List[A], f: A => Boolean): List[A] =  list match {
		case Cons(x, y) if f(x) => dropWhile(y, f)
		case _ => list
	}

	/**
	 * 述語とマッチする場合に限り削除する関数
	 * ※呼び出し側で型指定する必要がなくなる
	 */
	def dropWhileImprove[A](list: List[A])(f: A => Boolean): List[A] = list match {
		case Cons(x, y) if f(x) => dropWhileImprove(y)(f)
		case _ => list
	}
}