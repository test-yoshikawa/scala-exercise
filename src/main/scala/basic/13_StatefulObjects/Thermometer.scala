package basic.statefulobjects

/**
 * 温度計を扱うクラス
 */
class Thermometer {
	var celsius: Float = _ // _:型のデフォルト値（0.0）
	def fahrenheit = celsius * 9 / 5 + 32
	def fahrenheit_= (f: Float) {
		celsius = (f - 32) * 5/ 9
	}
	override def toString = fahrenheit + "F/" + celsius + "C"
}