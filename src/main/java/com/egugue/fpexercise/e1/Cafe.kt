package com.egugue.fpexercise.e1

class Cafe {

  /*
  fun buyCoffees(creditCard: CreditCard, n: Int): (List<Coffee>, Charge) {
    return null!!
  }
  */

  fun buyCoffee(cc: CreditCard): Pair<Coffee, Charge> {
    return Coffee() to Charge(cc, 10.0)

  }

  fun buyCoffees(cc: CreditCard, n: Int): Pair<List<Coffee>, Charge> {
    //val checkList: List<Pair<Coffee, Charge>> = (1..n).map { buyCoffee(cc) }
    val checkList: List<Pair<Coffee, Charge>> = List(n) { }.map { buyCoffee(cc) }
    val (coffees, charges) = checkList.unzip()
    val totalCharge: Charge = charges.reduce(Charge::combine)

    return coffees to totalCharge
  }

  fun coalesce(charges: List<Charge>): List<Charge> {
    return charges.groupBy(Charge::creditCard).values
        .map { charges -> charges.reduce(Charge::combine) }
  }
}