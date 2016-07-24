package workingwithxml

/** XMLサンプル */
class CCTherm {
	val description = "ht dog #5"
	val yearMade = 1952
	val dateObtained = "March 14, 2006"
	val bookPrice = 2199
	val purchasePrice = 500
	val condition = 9

	def toXml =
<cctherm>
	<description>{description}</description>
	<yearMade>{yearMade}</yearMade>
	<dateObtained>{dateObtained}</dateObtained>
	<bookPrice>{bookPrice}</bookPrice>
	<purchasePrice>{purchasePrice}</purchasePrice>
	<condition>{condition}</condition>
</cctherm>
}