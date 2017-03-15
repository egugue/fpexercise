package com.egugue.fpexercise.e1

data class Charge
(
    val creditCard: CreditCard,
    val amount: Double
) {

  fun combine(other: Charge): Charge =
      if (creditCard === other.creditCard) {
        Charge(creditCard, amount + other.amount)
      } else {
        throw IllegalArgumentException("$creditCard != " + other.creditCard)
      }
}