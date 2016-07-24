package object packagesandimports {

  /** フルーツの情報を表示
    *
    * @param fruit Fruit
    */
  def showFruit(fruit: Fruit) {
    import fruit._
    println(name + "'s are" + color)
  }
}