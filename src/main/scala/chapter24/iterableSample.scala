package scalableProgramming.chapter24

object iterableSample {

	def main(args: Array[String]): Unit = {
		val list1 = List(1, 2, 3, 4, 5)
		println("==== 抽象メソッド ====")
		val iterator1 = list1.iterator
		while (iterator1.hasNext) {
			print(iterator1.next() + "  ")
		}
		println()

		println("==== grouped ====")
		val groupList = list1 grouped 3		// 固定サイズ(=3)の「ひとかたまり」を渡すイテレーターを「返す
		while (groupList.hasNext) {
			print(groupList.next() + "  ")
		}
		println()

		println("==== sliding ====")
		val slidingList = list1 sliding 3	// 固定サイズ(=3)の「スライディングウィンドウ」を渡すイテレーターを返す
		while (slidingList.hasNext) {
			print(slidingList.next() + "  ")
		}
		println()

		println("==== サブコレクション（takeRight, dropzRight） ====")
		println(list1 takeRight 3)	// 最後のn(=3)個の要素で構成されるコレクションを返す
		println(list1 dropRight 3)	// list1 takeRight n(=3)を取り除いたコレクションを返す
		println()

		println("==== ジッパー ====")
		val list2 = List(3, 4, 5, 6)	// list1とlist2の対応する要素で作ったペアのイテラブルを返す。List((1,3), (2,4), (3,5), (4,6))
		val zip1 = list1 zip list2
		val zipAll1 = list1 zipAll (list2, 11, 12)	// list1とlist2の対応する要素で作ったペアのイテラブルを返す。(長いほうに合わせる)
		println(zip1)
		println(zipAll1)
		println(list1.zipWithIndex)	// list1とその展示のペアからなるイテラブルを返す。List((1,0), (2,1), (3,2), (4,3), (5,4))


		println("==== 比較 ====")
		println(list1 sameElements list2)
		println(list1 sameElements list1)
	}
}