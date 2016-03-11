package practice

object TheMissingList {

  /**
   * コレクションのサイズを数える（不完全）
   * 　引数の型がSetの場合は不整合が起こる
   */
  def sumSizes(collections: Iterable[Iterable[_]]): Int =
    collections.map{elem => println(elem + ".size: " + elem.size); elem.size}.sum

  /**
   * コレクションのサイズを数える（改良版）
   * 　mapする前に別のコレクション(toSeq)に返還させる(toListでもよい)
   */
  def sumSizesImproved(collections: Iterable[Iterable[_]]): Int =
    collections.toSeq.map(_.size).sum

  def sumSizesViaFoldLeft(collections: Iterable[Iterable[_]]): Int =
    collections.foldLeft(0) {
      (sumOfSizes, collections) => sumOfSizes + collections.size
    }

  def main(args: Array[String]): Unit = {
    val input1 = List(Set(1, 2), List(3, 4))
    val input2 = Set(List(1, 2), Set(3, 4))

    val result1 = sumSizes(input1) // => 4
    val result2 = sumSizes(input2) // => 2 (Setは同じ値を複数含むことはできない)
    println("==== normal ====")
    println("sumSizes(" + input1 + "): " + result1)
    println("sumSizes(" + input2 + "): " + result2)

    println("==== improve ====")
    val result3 = sumSizesImproved(input1) // => 4
    val result4 = sumSizesImproved(input2) // => 4 (mapする前に別のコレクションに変換したため)
    println("sumSizes(" + input1 + "): " + result3)
    println("sumSizes(" + input2 + "): " + result4)

    println("==== via foldLeft ====")
    val result5 = sumSizesViaFoldLeft(input1) // => 4
    val result6 = sumSizesViaFoldLeft(input2) // => 4 (mapする前に別のコレクションに変換したため)
    println("sumSizes(" + input1 + "): " + result5)
    println("sumSizes(" + input2 + "): " + result6)
  }
}