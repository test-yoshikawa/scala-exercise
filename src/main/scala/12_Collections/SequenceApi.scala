package collections

/** シーケンス サンプル */
object SequenceApi {

  /** メイン処理実行用
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
    // List: 先頭項目の追加・削除が高速
    println("==== List sample ====")
    val colors = List("red", "blue", "green")
    println("colors: " + colors)
    println("colors.head: " + colors.head)
    println("colors.tail: " + colors.tail)

    // Array: 添え字によって任意の位置の要素に効率的にアクセスできる
    println("\n==== Array sample ====")
    val fiveInts = new Array[Int](5)
    val fiveToOne = Array(5, 4, 3, 2, 1)
    println("new Array[Int](5) toList: " + fiveInts.toList)
    println("Array(5, 4, 3, 2, 1) toList: " + fiveToOne.toList)
    fiveInts(0) = fiveToOne(4)
    println("fiveInts(0) = fiveToOne(4) toList:  " + fiveInts.toList)

    // ListBuffer: 先頭・末尾ともに追加するときは一定時間。スタックオーバーフローが避けられる
    println("\n==== ListBuffer sample ====")
    val bufferList = new scala.collection.mutable.ListBuffer[Int]
    bufferList += 1
    println("bufferList add 1: " + bufferList)
    bufferList += 2
    println("bufferList add 2: " + bufferList)
    3 +=: bufferList	// 先頭追加
    println("bufferList add 3 to head: " + bufferList)

    // ArrayBuffer: 先頭・末尾で要素を追加・削除ができる
    println("\n==== ArrayBuffer sample ====")
    val bufferArray = new scala.collection.mutable.ArrayBuffer[Int]()
    bufferArray += 12
    bufferArray += 15
    18 +=: bufferArray	// 先頭へ追加
    println("bufferArray: " + bufferArray)
    println("bufferArray length: " + bufferArray.length)
    println("bufferArray(0): " + bufferArray(0))

    // StringOpts: PredefがStringからStringOptsへの暗黙の型変換を提供しているため、文字列をシーケンスのように扱うことができる
    println("\n==== StringOpts sample ====")
    def hasUpperCase(s: String) = s.exists(_.isUpper)
    println("hasUpperCase(\"Yoshikawa Yuki\"): " + hasUpperCase("Yoshikawa Yuki"))
    println("hasUpperCase(\"hello scala\"): " + hasUpperCase("hello scala"))
  }
}