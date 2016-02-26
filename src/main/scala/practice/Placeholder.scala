package practice

/**
 * プレースホルダ構文を使う際は生成される関数のスコープに注意する
 */
object placeholder {
  def main(args: Array[String]): Unit = {
    // 以下のステートメントは"arg => expr"という形式の
    // 一つの関数リテラルとして認識されるため、呼び出すたびに"Hi"が表示される
    List(1, 2).map { i => println("Hi"); i + 1}
    println("====")
    // 以下のステートメントは「println("Hi")」と「_ + 1」の
    // ２つの式だと認識されるため、引数がmapメソッドに渡される際の一度だけ実行される
    List(1, 2).map {println("Hi"); _ + 1}

    println("====")
    // ロケットシンボル(=>)からコードブロックの最後まですべてを含む匿名関数
    val regularFunc = {
      a: Any =>
        println("foo")
        println(a)
        "baz"
    }
    println(regularFunc("hello"))

    println("====")
    // アンダースコアを使っている式に限定される匿名関数
    val anonymousFunc = {
      println("foo")
      println(_: Any)
      "baz"
    }
    anonymousFunc(1)

    println("====")
    // anonymousFuncと等価
    val confinedFunc = {
      println("foo");
      {a: Any => println(a)};
      "baz"
    }
    confinedFunc(1)
  }
}