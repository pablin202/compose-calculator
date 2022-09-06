package com.example.calculator

data class CalculatorState(
    val number1: String ="",
    val number2: String = "",
    val operation: CalculatorOperation? = null
) {
    override fun toString(): String {
        return number1 + (operation?.symbol ?: "") + number2
    }
}
