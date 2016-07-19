package workingwithlist

import scala.language.postfixOps // warningが発生するためimport

object Lists {

	def main(args: Array[String]) {
		// Listリテラル
		val fruits = List("apples", "oranges", "pears")
		val nums = List(1, 2, 3, 4)
		val diag3 =
			List(
				List(1, 0, 0),
				List(0, 1, 0),
				List(0, 0, 1)
			)
		val empty = List()

		// Listの構築
		println("==== Construct List ====")
		val fruits2 = "apples" :: ("oranges" :: ("pears" :: Nil))
		val nums2 = 1 :: (2 :: (3 :: (4 :: Nil)))
		val diag32 = (1 :: (0 :: (0 :: Nil))) ::
									(0 :: (1 :: (0 :: Nil))) ::
									(0 :: (0 :: (1 :: Nil))) :: Nil
		val empty2 = Nil

		val test = List(4, 3, 2, 1)
		println(isort(test))

		// Listパターン
		println("\n==== List pattern ====")
		val List(a, b, c) = fruits
		println(a)
		println(b)
		println(c)
		val d :: e :: rest = fruits
		println(d)
		println(e)
		println(rest)
		println(isortPatternMatch(test))

		println("\n==== Combine List ====")
		val combineList = List(1, 2) ::: List(3, 4, 5)
		println(combineList)
		val appendedList = append(List(6, 7), List(8, 9))
		println(appendedList)

		println("\n==== Get List length ====")
		val length = List(1, 2, 3).length
		println(length)

		println("\n==== Access List init and last ====")
		val abcde = List('a', 'b', 'c', 'd', 'e')
		println(abcde.last)	// 最後の要素を返す
		println(abcde.init)	// 最後の要素を除く部分から成るリスト

		println("\n==== Reverse List ====")
		println(abcde.reverse)	// リストを反転する
		println(abcde)

		println("\n==== Prefix and Suffix ====")
		println( abcde take 2 )			// 先頭 N 個の要素を返す
		println( abcde drop 2 )			// 先頭 N 個以外の要素を返す
		println( abcde splitAt 2 )	// N分割をする

		println("\n==== Select Element ====")
		println( abcde apply 2 )	// Scalaではまれな使い方
		println( abcde(2) )				// Scalaではまれな使い方
		println( abcde.indices )	// 引数のリストで有効なすべての添え字から構成されるリストを返す

		println("\n==== Flatten List ====")
		val flattenList = List(List(1, 2), List(3), List(), List(4, 5)).flatten
		println(flattenList)
		println( fruits.map(_.toCharArray).flatten )

		println("\n==== Zipper List ====")
		val zippedList = abcde.indices zip abcde
		println(zippedList)
		println( abcde.zipWithIndex )
		println( zippedList unzip )

		println("\n==== toString and mkString ====")
		println( abcde.toString )
		println( abcde.mkString("[", ", ", "]") )
		println( abcde.mkString(" ") )

		println("\n==== Convert List ====")
		println( abcde.toArray )
		println( abcde.toList )
		val arr = new Array[Int](10)
		List(1, 2, 3) copyToArray (arr, 3)
		println( arr.mkString(", ") )
		val it = abcde.iterator
		println(it)
		println(it.next + ", " + it.next)

	}

	/**
	 * リストの要素を昇順にソートする
	 */
	def isort(xs: List[Int]): List[Int] =
		if (xs.isEmpty) Nil
		else insert(xs.head, isort(xs.tail))

	def insert(x: Int, xs: List[Int]): List[Int] =
		if (xs.isEmpty || x <= xs.head) x :: xs
		else xs.head :: insert(x, xs.tail)


	/**
	 * リストの要素を昇順にソートする(パターンマッチ)
	 */
	def isortPatternMatch(xs: List[Int]): List[Int] = xs match {
		case List() => Nil
		case x :: xs1 => insertPatternMatch(x, isortPatternMatch(xs1))
	}

	def insertPatternMatch(x: Int, xs: List[Int]): List[Int] = xs match {
		case List() => List(x)
		case y :: ys => if(x <= y) x :: xs
										else y :: insertPatternMatch(x, ys)
	}

	def append[T](xs: List[T], ys: List[T]): List[T] = xs match { // 戻り値の型を明示する必要あり
		case List() => ys
		case x :: xs1 => x :: append(xs1, ys)
	}
}