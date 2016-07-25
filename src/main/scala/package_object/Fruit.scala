package package_object

/** フルーツを定義した抽象クラス
  *
  * @param name 名前
  * @param color 色
  */
abstract class Fruit(val name: String, val color: String)

/** フルーツオブジェクト*/
object Fruits {
  object Apple extends Fruit("apple", "red")
  object Orange extends Fruit("orange", "orange")
  object Grape extends Fruit("grape", "wine-red")

  val menu = List(Apple, Orange, Grape)

  /** フルーツ情報を出力する
    *
    * @param fruit Fruit
    */
  def showFruit(fruit: Fruit) {
    import fruit._	// importは任意の場所に書ける
    println(name + "s are " + color)
  }
}