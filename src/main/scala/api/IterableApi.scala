package api

/** Iterable API */
object IterableApi {

  /** メイン処理
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]): Unit = {
    val list1 = List(1, 2, 3, 4, 5)
    println("list1: " + list1)
    println("==== abstract method ====")
    val iterator1 = list1.iterator
    println("list1.iterator: " + iterator1)
    print("=> elements: ")
    while (iterator1.hasNext) {
      print(iterator1.next() + "  ")
    }
    println()

    println("\n==== grouped ====")
    val groupList = list1 grouped 3  // 固定サイズ(=3)の「ひとかたまり」を渡すイテレーターを返す
    println("list1 grouped 3: " + groupList)
    print("=> elements: ")
    while (groupList.hasNext) {
      print(groupList.next() + "  ")
    }
    println()

    println("\n==== sliding ====")
    val slidingList = list1 sliding 3 // 固定サイズ(=3)の「スライディングウィンドウ」を渡すイテレーターを返す
    println("list1 sliding 3: " + slidingList)
    print("=> elements: ")
    while (slidingList.hasNext) {
      print(slidingList.next() + "  ")
    }
    println()

    println("\n==== sub collection ( takeRight, dropRight ) ====")
    println("list takeRight 3: " + (list1 takeRight 3)) // 最後のn(=3)個の要素で構成されるコレクションを返す
    println("list1 dropRight 3: " + (list1 dropRight 3)) // list1 takeRight n(=3)を取り除いたコレクションを返す

    println("\n==== zipper ====")
    val list2 = List(3, 4, 5, 6)
    val zip1 = list1 zip list2 // list1とlist2の対応する要素で作ったペアのイテラブルを返す。List((1,3), (2,4), (3,5), (4,6))
    val zipAll1 = list1 zipAll (list2, 11, 12) // list1とlist2の対応する要素で作ったペアのイテラブルを返す。(長いほうに合わせる)
    println("list1 zip list2: " + zip1)
    println("list1 zipAll (list, 11, 12): " + zipAll1)
    println("list1.zipWithIndex" + list1.zipWithIndex) // list1とその添字のペアからなるイテラブルを返す。List((1,0), (2,1), (3,2), (4,3), (5,4))

    println("\n==== compare ====")
    println("list1 sameElements list2: " + (list1 sameElements list2))
    println("list1 sameElements list1: " + (list1 sameElements list1))
  }
}