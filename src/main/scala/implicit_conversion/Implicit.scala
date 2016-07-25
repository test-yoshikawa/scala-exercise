package implicit_conversion

import scala.language.implicitConversions // warningが発生しないようにimport

/** Implicitオブジェクト */
object Implicit {
  implicit def stringToDouble(x: String): Int = x.length
}