package scalableProgramming.chapter24

object setSample {

	def main(args: Array[String]): Unit = {
		val set1 = Set("apple", "orange", "peach", "banana")	// immutable
		println("==== 分類とメソッド構文 ====")
		println("＜テスト＞")
		println(set1 contains "apple")	// 引数がset1の要素に含まれているかどうか調べる
		println(set1 contains "Apple")
		println(set1("apple"))			// 「set1 contains "apple"」と同じ
		val set1Sub1 = Set("apple", "orange")
		val set1Sub2 = Set("apple", "group")
		println(set1Sub1 subsetOf set1)	// set1Sub1がset1の部分集合かどうか調べる
		println(set1Sub2 subsetOf set1)

		println("\n＜追加＞")
		println(set1 + "group")				// 引数の要素を追加した集合を返す
		println(set1 + ("group", "melon"))	// 複数指定できる
		println(set1 ++ set1Sub2)			// 引数の集合を追加した集合を返す（重複はなし）

		println("\n＜削除＞")
		println(set1 - "peach")					// 引数の要素を削除した集合を返す（存在しない場合はそのまま返す）
		println(set1 - ("apple", "orange"))		// 複数指定できる
		println(set1 -- set1Sub1)				// 引数の集合を削除した集合を返す
		val empty1 = set1.empty
		val empty1Class = empty1.getClass
		println(empty1.toString + " : " + empty1Class.toString)						// seq1と同じクラスの空集合を返す

		println("\n＜二項演算＞")
		val set2 = Set("apple", "peach", "group")
		println(set1 & set2)			// 2つの積集合を返す
		println(set1 intersect set2)	// seq1 & seq2 と同じ
		println(set1 | set2)			// 2つの和集合を返す
		println(set1 union set2)		// set1 union set2 と同じ
		println(set1 &~ set2)			// 2つの差集合を返す
		println(set1 diff set2)			// set1 &~ set2　と同じ

		println("\n==== mutable.Setトレイトの演算・操作 ====")
		println("＜追加＞")
		var mutableSet1 = scala.collection.mutable.Set("Japan", "Austrailia")
		var mutableSet2 = scala.collection.mutable.Set("America", "Canada")
		println(mutableSet1 += "China")				// mutableSet1に要素を追加する（順序は保証されない）
		println(mutableSet1 += ("India", "Korea"))	// 複数追加できる
		println(mutableSet1 ++= mutableSet2)		// 引数の集合の要素を追加する
		println(mutableSet1 add "Japan")			// 要素を追加したうえで要素が元の集合に含まれているかどうか調べる（含む:false, 含まない:true）
		println(mutableSet1 add "Brazil")

		println("\n＜削除＞")
		println(mutableSet1 -= "China")				// 要素を削除する
		println(mutableSet1 -= ("India", "Korea"))	// 複数削除できる
		println(mutableSet1 --= mutableSet2)		// 引数の集合に含まれる要素を削除する
		println(mutableSet1 remove "Japan")			// 要素を削除したうえで要素が元の集合に含まれているかどうか調べる（含む:true, 含まない:false）
		println(mutableSet1 remove "Italia")
		mutableSet1 retain (_.length > 5)			// 条件を満たす要素だけを残す
		println(mutableSet1)

		println("\n＜更新＞")
		mutableSet1("Japan") = true 		// true : 要素を追加、false : 要素を削除
		mutableSet1("Brazil") = false
		println(mutableSet1)

		println("\nクローン作製")
		var cloneSet = mutableSet1.clone()	// mutableSet1のクローンを返す
		print(cloneSet)
		println(" " + cloneSet.getClass.toString)
	}
}