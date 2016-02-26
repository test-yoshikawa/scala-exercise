package practice

trait A {
  val audience: String
  println("Hello " + audience)
}

/**
 * コンストラクタが呼び出された時点ではaudienceはnullなので
 * "Hello null"と表示される
 */
class BMember(val a: String = "World") extends A {
  val audience = a
  println("I repeat: Hello " + audience)
}

/**
 * コンストラクタの引数が評価される時点で
 * audienceに即座に代入される
 */
class BConstructor(val audience: String = "World") extends A {
  println("I repead: Hello " + audience + "!")
}

/**
 * フィールドの事前定義を使えばコンストラクタの引数リストで
 * audienceを宣言するのと同じことを実現できる
 */
class BEarlyDef(a: String = "World") extends {
  val audience = a
} with A {
  println("I repeat: Hello " + audience + "!!")
}

trait AfterA {
  val introduction: String
  println(introduction)
}

/**
 * 直接継承しているスーパークラスや直接ミックスインしているトレイとは
 * クラス／トレイト／オブジェクトの宣言に登場する順番で左から右に初期化される
 */
class BEvery(val audience: String) extends {
  val introduction = {
    println("Evaluating early def")
    "Are you there?"
  }
} with A with AfterA {
  println("I repeat: Hello " + audience)
}

/**
 * スーパークラスのコンストラクタやスーパートレイトのイニシャライザは
 * クラスやオブジェクトの基本コンストラクタの先頭に、宣言の左から右の順に
 * 挿入される
 */
object Location {
  def main(args: Array[String]): Unit = {
    // １．引数"Readers"が評価される
    // ２．テンプレート（SuperClassのステートメント）を評価することで
    // 　　生成中のクラスを初期化する
    // 　　・初めにスーパークラスAのコンストラクタ
    // 　　・次にサブクラスのボディのステートメント
    println("==========")
    new BMember("Readers")
    println("==========")
    new BConstructor("Readers")

    // １．定義順に従って事前定義が実行される
    // ２．スーパークラスのコンストラクタ
    // ３．デフォルトコンストラクタ
    println("==========")
    new BEarlyDef("Readers")

    println("==========")
    new BEvery({println("Evaluating param"); "Readers"})
  }
}