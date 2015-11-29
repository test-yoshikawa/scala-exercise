package TheScalaCollectionsAPI

object TraversableSample {

	def main(args: Array[String]): Unit = {
		val list1 = List(1, 2, 3, 4, 5)

		println("==== 分類とメソッド構文 ====")
		list1.foreach(x => print(x))	// list1のすべての要素に対して実行する
		val list2 = List(4, 5, 6, 7, 8)

		println("\n==== 加算・追加 ====")
		println(list1 ++ list2)						// list1とlist2の両方の要素から構成されるコレクションを返す
		println(list1 map (1 + _))					// list1のすべての要素に「1 + _」を適用する
		println(list1 flatMap (x => Some(x + 10)))	// すべての要素に対してコレクションを結果型とする関数を適用した結果のコレクションを返す
		val list3 = List(1, "2", 3, "4", 5)
		val result1 = list3 collect {				// 定義されているものだけに対して適用した結果のコレクションを返す（今のところ型判定だけ？）
			case x:String => x  + "(string) "
			case x:Int => x + "(Int) "
		}
		println(result1)

		println("\n==== 変換 ====")
		println(list1.toArray)			// 配列に変換する
		println(list1.toList)			// Listに変換する(元々Listだけど・・・)
		println(list1.toIterable)		// Iterableに変換する
		println(list1.toSeq)			// シーケンスに変換する
		println(list1.toIndexedSeq)		// 添え字付きシーケンスに変換する
		println(list1.toStream)			// ストリーム(遅延評価されるシーケンス)に変換する
		println(list1.toSet)			// Setに変換する
		val listmap = List((1, 2), (3, 4))
		println(listmap.toMap)

		println("\n==== コピー ====")
		var buf1 = scala.collection.mutable.Buffer[Int](9, 8)
		list1 copyToBuffer buf1 			// コレクションをバッファーにコピーする
		println(buf1)
		var ary = Array[Int]()
		list1 copyToArray ary 			// コレクションを配列にコピーする
		println(ary)

		println("\n==== サイズ情報 ====")
		println(list1.isEmpty)			// 空かどうか判定(空: true)
		println(list1.nonEmpty)			// 含まれているかどうか判定（含まれている: true）
		println(list1.size)				// コレクションの要素数
		println(list1.hasDefiniteSize)	// 有限のサイズであることが確実ならtrueを返す

		println("\n==== 要素取得 ====")
		println(list1.head)					// 先頭要素を返す
		println(list1.headOption)			// 先頭要素をオプション値として返す
		println(list1.last)					// 最後の要素を返す
		println(list1.lastOption)			// 最後の要素をオプション値として返す
		println(list1 find (_ % 2 == 0))	// 条件を満たす最初の要素をオプション値として返す

		println("\n==== サブコレクション取得 ====")
		println(list1.tail)							// 先頭要素を除いた残りを返す
		println(list1.init)							// 最後の要素を除いた残りを返す
		println(list1 slice (1, 3))					// 添え字の範囲内(from～toの1つ前)のすべての要素のコレクションを返す
		println(list1 take 3)						// 最初のn個の要素のコレクションを返す
		println(list1 drop 3)						// list1 take 3 を除いたコレクションを返す
		println(list1 takeWhile (_ % 2 == 1))	// 条件に満たす要素を返す。満たさなかった時点で終了
		println(list1 dropWhile (_ % 2 == 1))	// list1 takeWhile (x => x % 2 == 1) を除いたコレクションを返す
		println(list1 filter (_ % 2 == 0))			// 条件を満たす要素のコレクションを返す
		val filter = list1 withFilter (_ % 2 == 0)	// フィルターを返す(リストではない)
		println(filter)
		filter.foreach(x => print(x + " "))
		println()
		println(list1.filterNot(_ % 2 == 0)) 		// 条件に満たさない要素のコレクションを返す

		println("\n==== 分割 ====")
		println(list1 splitAt 2)			// 分割して2つのコレクションを返す
		println(list1 span (_ % 2 == 1))	// 2つのコレクション「list1 takeWhile (_ % 2 == 1)」、「list1 dropWhile (_ % 2 == 1)」を返す
		println(list1 partition (_ % 2 == 0))		// 2つのコレクション「list1 filter (_ % 2 == 0)」、「list1 filterNot (_ % 2 == 0)」を返す
		println(list1 groupBy (_ % 2 == 0))			// 条件に従って分割したMapを返す Map（false -> ..., true -> ...）

		println("\n==== 要素条件 ====")
		println(list1 forall (_ % 2 == 0))			// すべての要素が条件を満たすがどうかを示す論理値を返す
		println(list1 exists (_ % 2 == 0))			// 条件を満たす要素があるかどうかを示す論理値を返す
		println(list1 count (_ % 2 == 0))			// 条件を満たす要素数を返す

		println("\n==== 畳み込み ====")	
		println((5 /: list1)(_ + _))				// 連続する要素に対して初期値(=5)から始めて左から右へ二項演算(_ + _)を適用した結果を返す
		println((list1 :\ 5)(_ + _))				// 上記とほとんど同じだが、右から左へ演算を行う
		println(list1.foldLeft(5)(_ + _))			// (5 /: list1)(_ + _)と同じ
		println(list1.foldRight(5)(_ + _))			// (list1 :\ 5)(_ + _)と同じ
		println(list1 reduceLeft (_ + _))			// 空でないコレクションに対して左から右へ演算を行う
		println(list1 reduceRight (_ + _))			// 上記と歩トンと同じだが、右から左へ演算を行う

		println("\n==== 型限定の畳み込み ====")
		println(list1.sum)			// 要素の和を求める
		println(list1.product)		// 要素の積を求める
		println(list1.min)			// コレクションの最小値要素を求める
		println(list1.max)			// コレクションの最大値要素を求める

		println("\n==== 文字列 ====")
		var str1 = new scala.collection.mutable.StringBuilder()
		var str2 = new scala.collection.mutable.StringBuilder()
		list1 addString (str1, "st", " & ", "end")		// 区切り文字で文字列を結合した結果をStringBuilderに格納する
		list1 addString (str2," & ")
		println(str1)
		println(str2)
		println(list1 mkString ("st", " & ", "end"))	// 区切り文字で文字列を結合した結果を返す
		println(list1 mkString (" & "))
		println(list1.stringPrefix)

		println("\n==== ビュー ====")
		println(list1.view)			// ビューを生成する
		println(list1.view(1, 3))	// 添え字範囲にある要素を表すビューを生成する

	}
}