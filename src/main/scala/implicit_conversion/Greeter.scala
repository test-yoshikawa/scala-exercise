package implicit_conversion

/** Greeterオブジェクト */
object Greeter {
  implicit val prompt = new PreferredPrompt("Yes, master>")
  implicit val drink = new PreferredDrink("tea")

  /** 挨拶文を出力する
    *
    * @param name 名前
    * @param prompt PreferredPrompt
    * @param drink PreferredDrink
    */
  def greet(name: String)(implicit prompt: PreferredPrompt, drink: PreferredDrink) {
    println("Welcome, " + name + ". The system is ready.")
    print("But while you work, ")
    println("why not enjoy acup of " + drink.preference + "?")
    println(prompt.preference)
  }
}