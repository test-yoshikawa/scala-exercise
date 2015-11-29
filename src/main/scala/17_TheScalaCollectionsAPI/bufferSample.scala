package TheScalaCollectionsAPI

import scala.collection.mutable._

object BufferSample {

	def main(args: Array[String]): Unit = {
		val buf1 = Buffer(1, 2, 3)

		println("==== 追加 ====")
		println(buf1 += 4)				// 末尾に要素を追加する
		println(buf1 += (5, 6, 7))		// 引数の要素を末尾に追加する
		val buf2 = Buffer(-1, 0)
		println(buf2 ++= buf1)			// すべての要素をバッファーに追加する
		println(0 +=: buf1)				// 先頭に要素を追加する
		buf1 insert(1, 99)				// 添え字i(=1)に要素を挿入する
		println(buf1)
		buf1 insertAll (1, Buffer(-99, -99, -99))// 添え字i(=1)にすべての要素を挿入する
		println(buf1)

		println("==== 削除 ====")
		println(buf1 -= 4)				// 要素を削除する
		buf1 remove (0)					// 添字i(=0)の要素を削除する
		println(buf1)
		buf1 remove (0, 3)				// 添字i(=0)を先頭とするn(=3)個の要素を削除する
		println(buf1)
		buf1 trimStart 1				// 先頭のn(=1)この要素を削除する
		println(buf1)
		buf1 trimEnd 3					// 末尾のn(=3)この要素を削除する
		println(buf1)
		val bufClone = buf1.clone 		// buf1と同じ要素を持つ新しいバッファーを返す
		buf1.clear()					// バッファーからすべての要素を削除する
		println(buf1)
		println("clone : " + bufClone)
	}
}