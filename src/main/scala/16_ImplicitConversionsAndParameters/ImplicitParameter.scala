package ImplicitConversionsAndParameters

import Implicit._	// 暗黙の型を利用したい場合はインポートをする
import GreeterPrefs._

object ImplicitParameter {

	def main(args: Array[String]): Unit = {
		// 暗黙のパラメータ１
		println("==== implicit parameter sample ====")
		val bobsPrompt = new PreferredPrompt("relax>")
		val bobsDrink = new PreferredDrink("cola")
		Greeter.greet("Bob")(bobsPrompt, bobsDrink)
		Greeter.greet("Joe")	// 暗黙でGreeterPrefsを利用している

		// 暗黙のパラメータ２
		println("\n==== implicit parameter sample 2 ====")
		println(maxList(List(1, 5, 10, 3)))
		println(maxList(List(1.5, 5.2, 19.7, 3.14159)))
		println(maxList(List("one", "two", "three")))
		println(maxList2(List(1, 5, 10, 3)))
		println(maxList2(List(1.5, 5.2, 19.7, 3.14159)))
		println(maxList2(List("one", "two", "three")))
	}

	/**
	 * リストの最大値を取得する
	 */
	def maxList[T](elements: List[T])(implicit orderer: T => Ordered[T]): T =
	elements match {
		case List() => throw new IllegalArgumentException("empty list!")
		case List(x) => x
		case x :: rest =>
			val maxRest = maxList(rest)	// 暗黙のうちに(orderer)が追加される
			if(x > maxRest) x					// 暗黙のうちにorderer(x)に変更される
			else maxRest
	}

	/**
	 * リストの最大値を取得する（可視境界を使用）
	 */
	def maxList2[T <% Ordered[T]](elements: List[T]): T =
	elements match {
		case List() => throw new IllegalArgumentException("empty list!")
		case List(x) => x
		case x :: rest =>
			val maxRest = maxList2(rest)	// 暗黙のうちに(orderer)が追加される
			if(x > maxRest) x					// 暗黙のうちにorderer(x)に変更される
			else maxRest
	}
}