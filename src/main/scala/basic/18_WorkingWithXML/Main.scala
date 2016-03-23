package basic.workingwithxml

object Main {
	def main(args: Array[String]) {
		val therm = new CCTherm()

		val xml = therm.toXml
		println(xml)
	}
}