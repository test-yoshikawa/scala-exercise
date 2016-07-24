package buildincontrol

/** Match式 サンプル */
object MatchApi {

  /** メイン実行
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) = {
    val firstArgs = if (args.length > 0) args(0) else ""
    firstArgs match {
      case "salt" => println("pepper")
      case "chips" => println("salsa")
      case "eggs" => println("bacon")
      case _ => println("huh?")
    }

    // 関数型スタイル
    val friend =
      firstArgs match {
        case "salt" => "pepper"
        case "chips" => "salsa"
        case "eggs" => "bacon"
        case _ => "huh?"
      }
    println(friend)
  }
}