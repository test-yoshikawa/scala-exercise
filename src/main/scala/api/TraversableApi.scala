package api

/** Traversable API */
object TraversableApi {

  /** メイン実行
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]): Unit = {
    val list1 = List(1, 2, 3, 4, 5)
    println("list1: " + list1)

    println("==== abstract method ====")
    print("list.foreach(x => print(x)): ")
    list1.foreach(x => print(x)) // list1のすべての要素に対して実行する

    println("\n\n==== Add ====")
    val list2 = List(4, 5, 6, 7, 8)
    println("list2: " + list2)
    println("list1 ++ list2: " + (list1 ++ list2))      // list1とlist2の両方の要素から構成されるコレクションを返す

    println("\n==== map ====")
    println("list1 map (1 + _): " + (list1 map (1 + _)))     // list1のすべての要素に「1 + _」を適用する
    println("list1 flatMap (x => Some(x + 10)): " + (list1 flatMap (x => Some(x + 10)))) // すべての要素に対してコレクションを結果型とする関数を適用した結果のコレクションを返す
    val list3 = List(1, -1, 3, -2, 5)
    val result1 = list3 collect {    // 定義されているものだけに対して適用した結果のコレクションを返す（今のところ型判定だけ？）
      case x: Int if x >= 0 => x + "(positive)"
      case x: Int if x < 0 => x + "(negative) "
    }
    println("list3: " + list3)
    println("list3 collect result: " + result1)

    println("\n==== Convert ====")
    println("list1.toArray: " + list1.toArray)    // 配列に変換する
    println("list1.toList: " + list1.toList)     // Listに変換する(元々Listだけど・・・)
    println("list1.toIterable: " + list1.toIterable)    // Iterableに変換する
    println("list1.toSeq: " + list1.toSeq)     // シーケンスに変換する
    println("list1.toIndexedSeq: " + list1.toIndexedSeq)  // 添え字付きシーケンスに変換する
    println("list1.toStream: " + list1.toStream)    // ストリーム(遅延評価されるシーケンス)に変換する
    println("list.toSet: " + list1.toSet)     // Setに変換する
    val listmap = List((1, 2), (3, 4))
    println("listmap: " + listmap)
    println("listmap.toMap" + listmap.toMap)

    println("\n==== Copy ====")
    val buf1 = scala.collection.mutable.Buffer[Int](9, 8)
    list1 copyToBuffer buf1  // コレクションをバッファーにコピーする
    println("list1 copyToBuffer buf1: " + buf1)
    val ary = Array[Int](10, 11)
    list1 copyToArray ary   // コレクションを配列にコピーする
    println("list1 copyToArray ary: Array(" + ary.mkString(", ") + ")")

    println("\n==== Size ====")
    println("list1.isEmpty: " + list1.isEmpty)  // 空かどうか判定(空: true)
    println("list1.notEmpty: " + list1.nonEmpty)  // 含まれているかどうか判定（含まれている: true）
    println("list1.size: " + list1.size)    // コレクションの要素数
    println("list1.hasDefiniteSize: " + list1.hasDefiniteSize) // 有限のサイズであることが確実ならtrueを返す

    println("\n==== Get Elements ====")
    println("list1.head: " + list1.head)     // 先頭要素を返す
    println("list1.headOption: " + list1.headOption)  // 先頭要素をオプション値として返す
    println("list1.last: " + list1.last)     // 最後の要素を返す
    println("list1.lastOption: " + list1.lastOption)  // 最後の要素をオプション値として返す
    println("list1 find (_ % 2 == 0): " + (list1 find (_ % 2 == 0))) // 条件を満たす最初の要素をオプション値として返す

    println("\n==== Get sub collection ====")
    println("list1.tail: " + list1.tail)       // 先頭要素を除いた残りを返す
    println("list1.init: " + list1.init)       // 最後の要素を除いた残りを返す
    println("list1 slice (1, 3): " + (list1 slice (1, 3)))   // 添え字の範囲内(from～toの1つ前)のすべての要素のコレクションを返す
    println("list1 take 3: " + (list1 take 3))      // 最初のn個の要素のコレクションを返す
    println("list1 drop 3" + (list1 drop 3))      // list1 take 3 を除いたコレクションを返す
    println("list1 takeWhile (_ % 2 == 1): " + (list1 takeWhile (_ % 2 == 1))) // 条件に満たす要素を返す。満たさなかった時点で終了
    println("list1 dropWhile (_ % 2 == 1): " + (list1 dropWhile (_ % 2 == 1))) // list1 takeWhile (x => x % 2 == 1) を除いたコレクションを返す
    println("list1 filter (_ % 2 == 0): " + (list1 filter (_ % 2 == 0)))   // 条件を満たす要素のコレクションを返す
    val filter = list1 withFilter (_ % 2 == 0) // フィルターを返す(リストではない)
    println("list1 withFilter (_ % 2 == 0) => filter: " + filter)
    print("=> result: ")
    filter.foreach(x => print(x + " "))
    println()
    println("list1.filterNot(_ % 2 == 0): " + list1.filterNot(_ % 2 == 0))   // 条件に満たさない要素のコレクションを返す

    println("\n==== Splits ====")
    println("list1 splitAt 2: " + (list1 splitAt 2))   // 分割して2つのコレクションを返す
    println("list1 span (_ % 2 == 1): " + (list1 span (_ % 2 == 1))) // 2つのコレクション「list1 takeWhile (_ % 2 == 1)」、「list1 dropWhile (_ % 2 == 1)」を返す
    println("list1 partition (_ % 2 == 0): " + (list1 partition (_ % 2 == 0)))  // 2つのコレクション「list1 filter (_ % 2 == 0)」、「list1 filterNot (_ % 2 == 0)」を返す
    println("list1 groupBy (_ % 2 == 0): " + (list1 groupBy (_ % 2 == 0)))   // 条件に従って分割したMapを返す Map（false -> ..., true -> ...）

    println("\n==== Element conditions ====")
    println("list forall (_ % 2 == 0): " + (list1 forall (_ % 2 == 0)))   // すべての要素が条件を満たすがどうかを示す論理値を返す
    println("list1 exists (_ % 2 == 0): " + (list1 exists (_ % 2 == 0)))   // 条件を満たす要素があるかどうかを示す論理値を返す
    println("list1 count (_ % 2 == 0): " + (list1 count (_ % 2 == 0)))   // 条件を満たす要素数を返す

    println("\n==== Convolutions ====")
    println("(5 /: list1)(_ + _): " + (5 /: list1)(_ + _))    // 連続する要素に対して初期値(=5)から始めて左から右へ二項演算(_ + _)を適用した結果を返す
    println("(list1 :\\ 5)(_ + _): " + (list1 :\ 5)(_ + _))    // 上記とほとんど同じだが、右から左へ演算を行う
    println("list1.foldLeft(5)(_ + _): " + list1.foldLeft(5)(_ + _))   // (5 /: list1)(_ + _)と同じ
    println("list1.foldRight(5)(_ + _): " + list1.foldRight(5)(_ + _))   // (list1 :\ 5)(_ + _)と同じ
    println("list1 reduceLeft (_ + _): " + (list1 reduceLeft (_ + _)))   // 空でないコレクションに対して左から右へ演算を行う
    println("list1 reduceRight (_ + _): " + (list1 reduceRight (_ + _)))   // 上記と歩トンと同じだが、右から左へ演算を行う

    println("\n==== Convolution by limited type ====")
    println("list1.sm: " + list1.sum)   // 要素の和を求める
    println("list1.profuct: " + list1.product)  // 要素の積を求める
    println("list1.min: " + list1.min)   // コレクションの最小値要素を求める
    println("list1.max: " + list1.max)   // コレクションの最大値要素を求める

    println("\n==== Strings ====")
    val str1 = new scala.collection.mutable.StringBuilder()
    val str2 = new scala.collection.mutable.StringBuilder()
    list1 addString (str1, "st", " & ", "end")  // 区切り文字で文字列を結合した結果をStringBuilderに格納する
    list1 addString (str2," & ")
    println("list1 addString (str1, \"st\", \"&\", \"end\"): " + str1)
    println("list1 addString (str2 \" & \"): " + str2)
    println("list1 mkString (\"st\", \"&\", \"end\"): " + (list1 mkString ("st", " & ", "end"))) // 区切り文字で文字列を結合した結果を返す
    println("list1 mkString (str2 \" & \"): " + (list1 mkString (" & ")))
    println("list1.stringPrefix: " + list1.stringPrefix) // xs.toStringが返す文字列の先頭にあるコレクション名を返す

    println("\n==== view ====")
    println("list1.view: " + list1.view)   // ビューを生成する
    println("list1.view(1, 3): " + list1.view(1, 3)) // 添え字範囲にある要素を表すビューを生成する
  }
}