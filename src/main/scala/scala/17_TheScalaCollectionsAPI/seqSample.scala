package scalableProgramming.chapter24

object seqSample {

	def main(args: Array[String]): Unit = {
		val seq1 = Seq(1, 2, 3, 4, 5)
		val seq2 = Seq(1, 2, 2, 4, 4, 4, 5)
		val seq3 = Seq(1, 3, 4, 2, 7, 5, 6)

		println("==== 添字参照、長さ ====")
		println(seq1(1))	// 添字iの要素を返す
		println(seq1.indices)			// 添字の範囲を取得
		println(seq1 isDefinedAt 1)		// i(=1)がseq.indicesに含まれているかどうか
		println(seq1 isDefinedAt 10)
		println(seq1 lengthCompare 2)	// seq1 > 2 : -1, seq1 < 2: 1, seq1 = 2 : 0

		println("\n==== 添字による検索 ====")
		val seqCountry = Seq("Japan", "China", "India", "America", "Japan")
		val seqCountry1 = Seq("Korea", "Australia", "Japan")
		println(seqCountry indexOf "Japan")						// seqCountryの中で一致する最初の要素の添字を返す
		println(seqCountry lastIndexOf "Japan")					// seqCountryの中で一致する最後の要素の添字を返す
		println(seqCountry indexOfSlice Seq("India"))			// seqCountryにシーケンスが含まれている最初の位置の先頭要素の添字を返す
		println(seqCountry lastIndexOfSlice Seq("Japan"))		// seqCountryにシーケンスが含まれている最後の位置の先頭要素の添字を返す
		println(seq1 indexWhere (_ % 2 == 0))					// 条件を満たす最初の要素の添字を返す
		println(seq2 segmentLength (_ % 2 == 0, 1))				// 指定した添字(=1)以降で条件を満たす連続した要素の中で最長となるものの長さを返す
		println(seq1 prefixLength (_  < 5))						// 条件を満たさない要素が出てくるまでの長さを返す

		println("\n==== 加算・追加 ====")
		println(6 +: seq1)				// seq1の前に要素を追加する
		println(seq1 :+ 6)				// seq1の後に要素を追加する
		println(seq1 padTo (10, 2))		// 長さが10に達するまで2を加えたシーケンスを返す

		println("\n==== 更新 ====")
		println("元Seq:" + seq1)
		println(seq1 patch (1, Seq(8), 2))	// 要素1から始まる2個の要素にパッチ8に置き換えて作ったシーケンスを返す。結果List(1, 8, 4, 5)
		println(seq1 updated (1, 99))		// 要素1の要素を99に置き換えたseq1のコピーを返す
		var mutSeq1 = scala.collection.mutable.Seq[Int](1, 1, 1)
		mutSeq1(2) = 3
		println(mutSeq1)

		println("\n==== ソート ====")
		println(seq3 sorted)			// 標準的な順序でソートする
		println(seq3 sortWith(_ > _))	// 定義したソート条件でソートする
		println(seq3 sortBy(-_))		// 要素に関数(-_)を適用した結果値でソートする。

		println("\n==== 逆順 ====")
		println(seq3.reverse)			// 逆順にしたシーケンスを返す
		println(seq3.reverseIterator)	// 逆順にしたイテレーターを返す
		println(seq3.reverseMap(-_))	// 逆順にしたものに対して関数を適用した結果値から作ったシーケンスを返す

		println("\n==== 比較 ====")
		println(seq1 startsWith Seq(1))	// seq1の先頭要素がSeq(1)になっているかどうか調べる = true
		println(seq1 startsWith Seq(2))	// false
		println(seq1 contains 3)	// seq1に指定したシーケンスが含まれているかどうか調べる
		println(seq1 containsSlice Seq(3))	// seq1が指定したシーケンスと等しいサブシーケンスを含むかどうか調べる
		println((seq1 corresponds seq2)(_ == _))
		println((seq1 corresponds seq1)(_ == _))

		println("\n==== 集合間演算 ====")
		println(seq1 intersect seq2)	// seq1とseq2の積集合を返す。要素の順序は保たれる
		println(seq1 diff seq2)			// seq1とseq2の差集合を返す。要素の順序は保たれる
		println(seq1 union seq3)		// 和集合を返す
		println(seq2.distinct)			// 重複する要素を取り除いたサブシーケンスを返す
	}
}