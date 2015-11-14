package scala.ImplicitConversionsAndParameters

object Greeter {

	def greet(name: String)(implicit prompt: PreferredPrompt, drink: PreferredDrink) {
		println("Welcome, " + name + ". The system is ready.")
		print("But while you work, ")
		println("why not enjoy acup of " + drink.preference + "?")
		println(prompt.preference)
	} 
}