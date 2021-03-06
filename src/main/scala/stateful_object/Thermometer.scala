package statefulobjects

/** 温度計を扱うクラス */
class Thermometer {
  var celsius: Float = _ // _:型のデフォルト値（0.0）

  /** 摂氏を取得
    *
    * @return
    */
  def fahrenheit = celsius * 9 / 5 + 32

  /** 摂氏に変換して保持する
    *
    * @param f Float
    */
  def fahrenheit_= (f: Float) {
    celsius = (f - 32) * 5/ 9
  }

  override def toString = fahrenheit + "F/" + celsius + "C"
}