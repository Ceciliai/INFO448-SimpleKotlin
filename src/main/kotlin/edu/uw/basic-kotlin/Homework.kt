package edu.uw.basickotlin

class Library {
    // This is just here as a placeholder, to make sure tests run and pass
    // before you add any code
    fun someLibraryMethod(): Boolean {
        return true
    }
}

// write a "whenFn" that takes an arg of type "Any" and returns a String
fun whenFn(input: Any): String {
    return when(input) {
        "Hello" -> "world"
        "Bonjour" -> "Say what?"
        "Howdy" -> "Say what?"
        0 -> "zero"
        1 -> "one"
        in 2..10 -> "low number"
        is Int -> "a number"
        else -> "I don't understand"
    }
}



// write an "add" function that takes two Ints, returns an Int, and adds the values
fun add(a: Int, b: Int): Int = a + b

// write a "sub" function that takes two Ints, returns an Int, and subtracts the values
fun sub(a: Int, b: Int): Int = a - b

// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
fun mathOp(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

// write a class "Person" with first name, last name and age
class Person(val firstName: String, val lastName: String, val age: Int) {
    val debugString: String
        get() = "[Person firstName:$firstName lastName:$lastName age:$age]"
}

// write a class "Money" with amount and currency, and define a convert() method and the "+" operator
class Money(val amount: Int, val currency: String) {
    init {
        require(amount >= 0) { "Amount can never be less than zero" }
        require(currency in listOf("USD", "EUR", "CAN", "GBP")) { "Invalid currency" }
    }
    fun convert(toCurrency: String): Money {
        val conversionRate = getConversionRate(currency, toCurrency)
        return Money((amount * conversionRate).toInt(), toCurrency)
    }

    operator fun plus(other: Money): Money {
        val converted = other.convert(this.currency)
        return Money(this.amount + converted.amount, this.currency)
    }

    private fun getConversionRate(from: String, to: String): Double {
    val rates = mapOf(
        "USD" to mapOf("GBP" to 0.5, "EUR" to 1.5, "CAN" to 1.25),
        "GBP" to mapOf("USD" to 2.0, "EUR" to 3.0, "CAN" to 2.5),
        "EUR" to mapOf("USD" to 1 / 1.5, "GBP" to 1 / 3.0, "CAN" to 5 / 3.0),
        "CAN" to mapOf("USD" to 1 / 1.25, "GBP" to 2 / 5.0, "EUR" to 3 / 5.0)
    )
    return rates[from]?.get(to) ?: 1.0
    }


}