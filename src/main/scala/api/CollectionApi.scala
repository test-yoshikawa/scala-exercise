package api

/** コレクション サンプル */
object CollectionApi {

  /** メイン処理
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
    3 +=: bufferList // 先頭追加
    println("bufferList add 3 to head: " + bufferList)

    // ArrayBuffer: 先頭・末尾で要素を追加・削除ができる
    println("\n==== ArrayBuffer sample ====")
    val bufferArray = new scala.collection.mutable.ArrayBuffer[Int]()
    bufferArray += 12
    bufferArray += 15
    18 +=: bufferArray // 先頭へ追加
    println("bufferArray: " + bufferArray)
    println("bufferArray length: " + bufferArray.length)
    println("bufferArray(0): " + bufferArray(0))

    // StringOpts: PredefがStringからStringOptsへの暗黙の型変換を提供しているため、文字列をシーケンスのように扱うことができる
    println("\n==== StringOpts sample ====")
    def hasUpperCase(s: String) = s.exists(_.isUpper)
    println("hasUpperCase(\"Yoshikawa Yuki\"): " + hasUpperCase("Yoshikawa Yuki"))
    println("hasUpperCase(\"hello scala\"): " + hasUpperCase("hello scala"))

    println()
    println("==== Map methods ====")
    showMapApis()

    println()
    println("==== Set methods ====")
    showSetApis()
  }

  /** Map の一般的な操作を出力する */
  def showMapApis() {
    val map = scala.collection.mutable.Map.empty[String, Int]
    map("hello") = 1
    map("there") = 2
    println("map variable: " + map)
    println("map(\"hello\") value: " + map("hello"))
    println("map(\"there\") value: " + map("there"))
    try {
      println("map(\"empty\")：" + map("empty")) // 例外発生：NoSuchElementException
    } catch {
      case e: NoSuchElementException => println("NoSuchElementException")
    }
    val nums = Map("i" -> 1, "li" -> 2) // immutable な Map を作成
    println("immutable.nums: " + nums)
    println("nums + (\"vi\" -> 6): " + (nums + ("vi" -> 6))) // エントリーを追加する
    println("nums - \"li\": " + (nums - "li")) // エントリーを削除する
    println("nums ++ List(\"iii\" -> 3, \"v\" -> 5): " + (nums ++ List("iii" -> 3, "v" -> 5))) // 複数のエントリーを追加する
    println("nums -- List(\"i\", \"li\", \"iii\"): " + (nums -- List("i", "li", "iii"))) // 複数のエントリーを削除する
    println("nums.size: " + nums.size) // Mapのサイズを返す
    println("nums.contains(\"li\"): " + nums.contains("li")) // キーが含まれているか確認する(return type: Boolean)
    println("nums(\"li\"): " + nums("li")) // 指定したキーに対応する値を返す
    println("nums.keys: " + nums.keys) // キー(Iterable)を返す
    println("nums.keySet: " + nums.keySet) // キーの集合を返す
    println("nums.values: " + nums.values) // 値(Itterable)を返す
    println("nums.isEmpty: " + nums.isEmpty) // 空かどうか確認する

    val words = scala.collection.mutable.Map.empty[String, Int]
    println("mutable.words: " + words)
    words += ("one" -> 1)
    println("add entry: " + words)
    words -= "one"
    println("delete entry: " + words)
    words ++= List("one" -> 1, "two" -> 2, "three" -> 3)
    println("add entrys: " + words)
    words --= List("one", "two")
    println("delete entrys: " + words)
  }

  /** Setの一般的な操作を出力する */
  def showSetApis() {
    val nums = Set(1, 2, 3) // immutableな集合を作成
    println("nums: " + nums)
    println("nums + 5: " + (nums + 5)) // 要素が追加された集合を返す
    println("nums - 3: " + (nums - 3)) // 指定した要素が削除された集合を返す
    println("nums ++ List(5, 6): " + (nums ++ List(5, 6))) // 複数の要素を追加する(順序は保証されない？)
    println("nums -- List(1, 2, 5): " + (nums -- List(1, 2, 5))) // 複数の要素を取り除く
    println("nums & Set(1, 3, 5, 7): " + (nums & Set(1, 3, 5, 7))) // 2つの集合の積集合を返す
    println("nums.size: " + nums.size) // 集合のサイズを返す
    println("nums.contains(3): " + nums.contains(3)) // 要素が含まれているか判定する
    val words = scala.collection.mutable.Set.empty[String] // 空のmutable集合を返す
    println("mutable.words: " + words)
    words += "the" // 要素を追加する
    println("words add \"the\": " + words)
    words -= "the" // 要素を削除する
    println("words delete \"the\": " + words)
    words ++= List("do", "re", "mi") // 複数の要素を追加する
    println("words add multiple elements: " + words)
    words --= List("do", "re") // 複数の要素を削除する
    println("words delete multiple elements: " + words)
    words.clear // すべての要素を削除する
    println("words clear: " + words)
  }
}