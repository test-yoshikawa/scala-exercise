package ImplicitConversionsAndParameters

object JoePrefs {
	implicit val prompt = new PreferredPrompt("Yes, master>")
	implicit val drink = new PreferredDrink("tea")
}