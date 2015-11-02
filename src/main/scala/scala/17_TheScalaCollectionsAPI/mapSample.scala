package scala.TheScalaCollectionsAPI

object mapSample {

	def main(args: Array[String]): Unit = {
		val map1 = Map(1 -> "a", 2-> "b", 3-> "c", 4 ->"d")
		println("==== ルックアップ ====")
		println(map1 get 1)			// 指定したキーに対応する値をオプション値で返す。なければNoneを返す
		println(map1 get 0)			// None
		println(map1(1))			// 指定したキーに対応する値を返す。なければ例外を投げる
		println(map1 contains 2)	// 指定したキーのマッピングを含んでいるかどうか調べる
		println(map1 contains 0)
		println(map1 isDefinedAt 2)	// containsと同じ
		println(map1 isDefinedAt 0)

		println("\n==== 追加と更新 ====")
		println(map1 + (5 -> "e"))				// キーと値のペアを追加したMapを返す
		println(map1 + (6 -> "f", 7 -> "g"))	// 複数指定できる
		val kvs1 = Map(8 -> "i", 9 -> "j")
		println(map1 ++ kvs1)					// 引数のMapを追加したMapを返す
		println(map1 updated (10, "k"))		// +と同じ

		println("\n==== 削除 ====")
		println(map1 - 2)			// 指定したキーに対応する値を削除したMapを返す
		println(map1 - (2, 3 ,4))	// 複数指定できる
		val ks = List(2, 3, 4)
		println(map1 -- ks)		// 指定したキーのコレクション(MapはNG)に含まれる要素を削除したMapを返す

		println("\n==== サブコレクション作成 ====")
		println(map1.keys)				// Mapの各キーを含むイテラブル（Set）を返す
		println(map1.keySet)			// 各キーの含む集合を返す
		println(map1.keysIterator)		// 各キーを含むイテレーターを返す
		println(map1.values)			// キーに対応する個々の値を含むイテラブルを返す
		println(map1.valuesIterator)	// キーに対応する個々の値を含むイテレーターを返す

		println("\n==== 変形 ====")
		println(map1 filterKeys (_ % 2 == 0))	// キーが条件を満たすものだけを含むマップビューを返す
		println(map1 mapValues (_ + " mapping!"))		// キーに対応する各値に条件を適用して作ったマップビューを返す

		println("==== Mutable ====")
		println("==== 追加と更新 ====")
		var mutableMap1 = scala.collection.mutable.Map(1 -> "a", 2-> "b", 3-> "c", 4 ->"d")
		mutableMap1(5) = "e"					// 指定したキーと値のペアを追加する 
		println(mutableMap1)
		mutableMap1 += (6 -> "f", 7 -> "g")		// 複数指定できる
		println(mutableMap1)
		mutableMap1 ++= kvs1					// 指定したMapを追加する
		println(mutableMap1)
		mutableMap1 put (10, "k")				// 指定したキーと値のペアを追加する
		println(mutableMap1)
		println(mutableMap1 getOrElseUpdate (10, "j"))	// 指定したキーが定義されていれば対応する値を返す。そうでなけれが指定したキー/値で更新（追加）する
		println(mutableMap1 getOrElseUpdate (11, "j"))	
		println(mutableMap1)

		println("\n==== 削除 ====")
		mutableMap1 -= 5				// 指定したキーの写像を削除する
		println(mutableMap1)
		mutableMap1 -= (6, 7)			// 複数指定できる
		println(mutableMap1)
		mutableMap1 --= ks				// 指定したMapを含む写像を削除する
		println(mutableMap1)
		println(mutableMap1 remove 1)	// 指定したキーの写像を削除し、対応する値をオプション値として返す
		println(mutableMap1)
		mutableMap1 retain ((k, v) => k % 2 == 0)	// 条件を満たすキーの写像を残す
		println(mutableMap1)
		mutableMap1.clear()				// すべての写像をクリアする
		println(mutableMap1)

		println("\n==== 変形とクローン作成 ====")
		var mutableMap2 = scala.collection.mutable.Map(1 -> "a", 2-> "b", 3-> "c", 4 ->"d")
		var clone1 = mutableMap2.clone
		mutableMap2 transform (_ + _.toUpperCase) // 1つ目の_:key, 2つ目の_:value
		println(mutableMap2)
		println(clone1)
	}
}