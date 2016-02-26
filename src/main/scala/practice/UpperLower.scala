package practice

/**
 * 大文字の変数名は定数の場合のみ使用する
 */
object upperlower {

  def main(args: Array[String]): Unit = {
    var MONTH = 12
    var DAY = 24
    // 複数の大文字変数への代入はコンパイルエラー
    // パターンマッチに基づいていることで発生する
    // 大文字で始まる変数名は安定識別子として特別な意味を持つ
    // var (HOUR, MINUTE, SECOND) = (12, 0, 0)

    // 小文字で始まる変数名は変数パターンになるため、エラーなし
    var (hour, minute, secont) = (12, 0, 0)

    val HOUR = 12
    val MINUTE, SECOND = 0
    // マッチに成功した場合は何も起こらない
    var (HOUR, MINUTE, SECOND) = (12, 0, 0)

    val HOUR1 = 13
    val MINUTE1, SECOND1 = 0
    // マッチに失敗した場合は実行例外がスローされる（コンパイルは通る）
    var (HOUR1, MINUTE1, SECOND1) = (12, 0, 0)

    val theAnswer = 42
    // バッククォート（シングルクォートではない）で囲むことで安定識別子として扱うことができる
    // ただし、valで宣言されていなくてはいけない
    def checkGuess(guess: Int) = guess match {
      case `theAnswer` => "Your guess is correct"
      case _ => "Try again"
    }
  }
}