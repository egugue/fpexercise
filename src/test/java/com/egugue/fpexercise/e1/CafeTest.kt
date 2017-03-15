package com.egugue.fpexercise.e1

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CafeTest {

  @Test fun foo() {
    val cc1 = CreditCard()
    val charges1 = listOf(
        Charge(cc1, 10.0),
        Charge(cc1, 10.0),
        Charge(cc1, 10.0))

    val cc2 = CreditCard()
    val charges2 = listOf(
        Charge(cc2, 10.0),
        Charge(cc2, 20.0),
        Charge(cc2, 30.0))

    val merged = charges1.plus(charges2)
    val actual = Cafe().coalesce(merged)

    assertThat(actual).isEqualTo(listOf(
        Charge(cc1, 30.0),
        Charge(cc2, 60.0)
    ))
  }
}