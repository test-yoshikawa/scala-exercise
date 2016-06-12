package basic.implicitconversion

import scala.language.implicitConversions // warningが発生しないようにimport

object Implicit {
	implicit def stringToDouble(x: String): Int = x.length
}