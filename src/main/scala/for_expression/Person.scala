package for_expression

/** Person Case Class
  *
  * @param name 名前
  * @param isMale true: 男性, false: 女性
  * @param children 子供（複数あり）
  */
case class Person(name: String, isMale: Boolean, children: Person*)

/**
 * for式
 */
object Person {

  /** メイン実行
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
    val lara = Person("Lara", false)
    val bob = Person("Bob", true)
    val julie = Person("Julie", false, lara, bob)
    val persons = List(lara, bob, julie)

    println("==== show the pair of mother and child ====")
    println("persons: " + persons)
    val all1 = persons.filter(p => !p.isMale).flatMap(p => p.children.map(c => (p.name, c.name)))
    val all2 = persons.withFilter(p => !p.isMale).flatMap(p => p.children.map(c => (p.name, c.name)))
    println("result1: " + all1)
    println("result2: " + all2)

    // for文を使用したほうがわかりやすい！
    val all3 = for (p <-persons if !p.isMale; c <-p.children) yield (p.name, c.name)
    println("result3: " + all3)
  }
}