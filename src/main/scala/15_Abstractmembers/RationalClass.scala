package AbstractMembers

class RationalClass(n: Int, d: Int) extends {
	val numerArg = n
	val denomArg = d
} with RationalTrait {
	def + (that: RationalClass) = new RationalClass(
		numer * that.denom + that.numer * denom,
		denom * that.denom
	)
}