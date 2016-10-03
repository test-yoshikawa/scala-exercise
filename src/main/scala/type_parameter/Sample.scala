package type_parameter

class MyData[T] {
  def getThree(i: T) = println(s"$i $i $i")
}

object Sample {
  def main(args: Array[String]): Unit = {
    val i = new MyData[Int]
    i.getThree(3)

    val s = new MyData[String]
    s.getThree("test")
  }
}
