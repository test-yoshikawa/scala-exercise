package work

/** マージソート */
object MergeSort {

  /** メイン実行
    *
    * @param args
    */
  def main(args: Array[String]) {
    val msorted = msort((x: Int, y: Int) => x < y)(List(5, 7, 1, 3))
    println(msorted)

    val mixedInts = List(4, 1, 9, 0, 5, 8, 3, 6, 2, 7)
    val intSort = msort((x: Int, y: Int) => x < y) _
    val reverseIntSort = msort((x: Int, y: Int) => x > y) _
    println(intSort(mixedInts))
    println(reverseIntSort(mixedInts))
  }

  /** マージソート
    *
    * @param less ソート条件
    * @param xs List[T]
    * @tparam T
    * @return List[T]
    */
  def msort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (less(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(msort(less)(ys), msort(less)(zs))
    }
  }
}