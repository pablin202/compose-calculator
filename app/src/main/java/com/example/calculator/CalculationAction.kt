package com.example.calculator

sealed class CalculationAction {
    data class Number(val number: Int) : CalculationAction()
    object Clear : CalculationAction()
    object Delete: CalculationAction()
    object Decimal: CalculationAction()
    object Calculate: CalculationAction()
    data class Operation(val operation: CalculatorOperation): CalculationAction()
}
