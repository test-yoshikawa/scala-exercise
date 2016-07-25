package extractors

/** 抽出子サンプル　実行用 */
object Main {

  /** メイン実行
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
    println("==== Email Extraction ====")
    val address = Email("passion-yukki", "gmail.com")
    val email = "passion-yukki@gmail.com"
    val selectorString = Email.selectorString(email);
    println("Email apply: " + address)
    println("Email.selectorString(\"" + email + "\") => " + selectorString)

    println("\n==== Twice Extraction ( Twice.userTwiceUpper ) ====")
    println("YOYO@gmail.com => " + Twice.userTwiceUpper("YOYO@gmail.com"))
    println("YOYI@gmail.com => " + Twice.userTwiceUpper("YOYI@gmail.com"))
    println("yoyo@gmail.com => " + Twice.userTwiceUpper("yoyo@gmail.com"))

    println("\n==== Domain Extraction ( Domain.isYoshiInDotCom ) ====")
    println("yoshi@gmail.com => " + Domain.isYoshiInDotCom("yoshi@gmail.com"))
    println("scala@gmail.com => " + Domain.isYoshiInDotCom("scala@gmail.com"))
    println("yoshi@gmail.org => " + Domain.isYoshiInDotCom("yoshi@gmail.org"))

    println("\n==== ExpandedEmail Extraction ====")
    val s = "yoshi@support.scala.com"
    val ExpandedEmail(name, topdom, subdoms @ _*) = s
    println(s)
    println("=> name: " + name)
    println("=> topdom: " + topdom)
    println("=> subdoms: " + subdoms)
  }
}