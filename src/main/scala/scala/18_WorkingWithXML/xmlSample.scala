package scala.WorkingWithXML

object xmlSample {

	def main(args: Array[String]): Unit = {
		val therm = new CCTherm()

		val xml = therm.toXml
		println(xml)
	}
}