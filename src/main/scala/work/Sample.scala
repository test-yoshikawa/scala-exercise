package work

object Sample {

  val multiFunc: (Int, Int) => Int = (a: Int , b: Int) => a * b // 型指定の省略可能

  /** メイン処理
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]): Unit = {
    // 文字列のデータ操作
    showString()
    println()
    // match式による出力
    showMatch()
    println()
    // 関数オブジェクト
    showFunctionalObject()
    println()
    // Collectionの操作
    showCollection()
    println()
    // Either(イーザー型)
    def div(a: Int, b: Int): Either[String, Int] = {
      if(b == 0) Left("zero division error!")
      else Right(a / b)
    }
    div(10, 0) match {
      case Right(n) => println(n)
      case Left(n) => println(n)
    }


  }

  /** show message
    *
    * @param from from
    * @param to to
    * @param text content
    * @return message
    */
  def msg(from: String, to: String, text: String) = s"($from -> $to): $text "

  /** 文字れるによるデータ操作
    *
    * - 文字列に変数を埋め込み
    *
    * - さらに書式を指定
    *
    */
  def showString() = {
    val name = "yoshikawa"
    val score = 80
    val height = 158.3

    // 文字列のデータ操作
    println(s"name $name, score: $score, height: $height")
    println(s"name $name, score: ${score + 10}, height: $height")
    // 書式を指定できる
    println(f"name $name%s, score: $score%d, height: $height%f")
    println(f"name $name%10s, score: $score%10d, height: $height%10f")
    println(f"name $name%10s, score: $score%-10d, height: $height%10f")
    println(f"name $name%10s, score: $score%-10d, height: $height%10.2f")
  }

  /** Match式による出力 */
  def showMatch() = {
    // match式のサンプル
    val signal = "pink"
    val result = signal match {
      case "red" => "stop"
      case "blue" | "green" => "go"
      case "yellow" => "caution"
      case other => s"wrong signal: ${other}"
    }
    println(result)
  }

  /** 関数オブジェクト */
  def showFunctionalObject() = {
    val multiFuncCurried = (a: Int) => (b: Int) => a * b
    val double = multiFuncCurried(2)
    val triple = multiFuncCurried(3)
    println("functional object: " + multiFunc(2, 3))
    println("curried function: " + multiFuncCurried(4)(2))
    println("double number: " + double(12))
    println("triple number: " + triple(15))
    println()
    // 部分適用
    val msgToYoshi = msg(_: String, "Yoshi", _:String)
    println(msgToYoshi("Taro", "Hello!"))
  }

  /** Collectionの操作  */
  def showCollection() = {
    // List の操作
    val scores = 200 :: 300 :: 400 :: Nil // Nil: 空のList
    println(scores.length)
    println(scores.isEmpty)
    println(scores.head)
    println(scores(1))
    println()
    // Set の操作
    val answers = Set(5, 3, 8, 5)
    println(answers)            // 5, 3, 8
    println(answers.contains(3)) // true
    println(answers(2))          // false(= contains)
    val set1 = Set(1, 3, 5, 8)
    val set2 = Set(3, 5, 8, 9)
    println(set1 & set2) // intersect(積集合)
    println(set1 | set2) // union(和集合)
    println(set1 &~ set2) // diff(差分)
    println()

    // Map の操作
    val sales = Map("yoshi" -> 200, "yuki" -> 400)
    println(sales("yoshi"))
    println(sales.contains("scala-exercise"))
    println(sales.getOrElse("yoshi", "none"))
    println(sales.getOrElse("scala-exercise", "none"))
  }
}
