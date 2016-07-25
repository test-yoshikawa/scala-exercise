package type_parameter

/** Personを扱うクラス
  *
  * @param firstName String
  * @param lastName String
  */
class Person(val firstName: String, val lastName: String) extends Ordered[Person] {

  /** ソート定義（lastNameでソートする）
    *
    * @param that Person
    * @return `x` where:
    *   - `x < 0` when `this < that`
    *   - `x == 0` when `this == that`
    *   - `x > 0` when  `this > that`
    */
  def compare(that: Person) = {
    val lastNameComparison = lastName.compareToIgnoreCase(that.lastName)
    if (lastNameComparison != 0)
      lastNameComparison
    else
      firstName.compareToIgnoreCase(that.firstName)
  }

  override def toString = firstName + " " + lastName
}