package basic.implicitconversion

object GreeterPrefs {
	implicit val prompt = new PreferredPrompt("Yes, implicit master>")
	implicit val drink = new PreferredDrink("tea")
}