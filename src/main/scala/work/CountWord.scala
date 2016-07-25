package work

import scala.collection._

/** 使用されている単語をカウントする */
object CountWord {

  /** メイン処理
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
    // 文章
    val text = "See Spot run. Run, Spot . Run!"

    // 文章から単語を取得する
    print("get words by Map : ")
    println(countWords(text))

    // 単語を取得する（大文字小文字は別）
    val wordsArray = text.split("[ !,.]+")
    println("Sentence: " + text)
    print("Get word: ")
    println(wordsArray.mkString(" "))

    // 単語の種類を取得する
    val wordsSet = scala.collection.mutable.Set.empty[String]
    for (word <- wordsArray) wordsSet += word.toLowerCase
    print("get kinds of word: ")
    println(wordsSet)
  }

  /** 文章から単語を取得する
    *
    * @param text String
    * @return 単語Map(単語 -> 含まれている個数)
    */
  def countWords(text: String) = {
    val counts = mutable.Map.empty[String, Int]

    for (ranWord <- text.split("[ !,.]+")) {
      val word = ranWord.toLowerCase
      val oldCount =
        if (counts.contains(word)) counts(word)
        else 0
      counts += (word -> (oldCount + 1))
    }
    counts
  }
}