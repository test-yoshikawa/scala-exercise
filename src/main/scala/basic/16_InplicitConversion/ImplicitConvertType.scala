package basic.implicitconversion

import scala.language.implicitConversions // warningが発生しないようにimport

object ImplicitConvertType {
	implicit def doubleToInt(x: Double) = x.toInt

	def main(args: Array[String]): Unit = {
		println("==== Implicit convert type sample ====")
		val i: Int = 3.5
		println("i: Int: " + i + " (variable \"i\" converted type by doubleToInt method)")
	}
}