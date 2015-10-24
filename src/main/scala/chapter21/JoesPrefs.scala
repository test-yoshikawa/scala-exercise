package scalableProgramming.chapter21

object JoePrefs {
	implicit val prompt = new PreferredPrompt("Yes, master>")
	implicit val drink = new PreferredDrink("tea")
}