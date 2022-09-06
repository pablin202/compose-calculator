package com.example.calculator

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test

class CalculatorViewModelTest {

    @Test
    fun `OnAction should get a result when there are 2 numbers and an Add operator`() {
        val viewModel = CalculatorViewModel()
        viewModel.onAction(CalculationAction.Number(5))
        viewModel.onAction(CalculationAction.Operation(CalculatorOperation.Add))
        viewModel.onAction(CalculationAction.Number(15))
        viewModel.onAction(CalculationAction.Calculate)

        val expected = "20.0"
        val result = viewModel.state.toString()

        assertThat(expected, `is`(result))
    }

    @Test
    fun `OnAction should get a result when there are 2 numbers and an Subtract operator`() {
        val viewModel = CalculatorViewModel()
        viewModel.onAction(CalculationAction.Number(15))
        viewModel.onAction(CalculationAction.Operation(CalculatorOperation.Subtract))
        viewModel.onAction(CalculationAction.Number(10))
        viewModel.onAction(CalculationAction.Calculate)

        val expected = "5.0"
        val result = viewModel.state.toString()

        assertThat(expected, `is`(result))
    }

    @Test
    fun `OnAction should get a result when there are 2 numbers and an Multiply operator`() {
        val viewModel = CalculatorViewModel()
        viewModel.onAction(CalculationAction.Number(5))
        viewModel.onAction(CalculationAction.Operation(CalculatorOperation.Multiply))
        viewModel.onAction(CalculationAction.Number(5))
        viewModel.onAction(CalculationAction.Calculate)

        val expected = "25.0"
        val result = viewModel.state.toString()

        assertThat(expected, `is`(result))
    }

    @Test
    fun `OnAction should get a result when there are 2 numbers and an Divide operator`() {
        val viewModel = CalculatorViewModel()
        viewModel.onAction(CalculationAction.Number(15))
        viewModel.onAction(CalculationAction.Operation(CalculatorOperation.Divide))
        viewModel.onAction(CalculationAction.Number(5))
        viewModel.onAction(CalculationAction.Calculate)

        val expected = "3.0"
        val result = viewModel.state.toString()

        assertThat(expected, `is`(result))
    }

    @Test
    fun `OnAction should remove the last number of the first number when there is one number and press Delete`() {
        val viewModel = CalculatorViewModel()
        viewModel.onAction(CalculationAction.Number(55))
        viewModel.onAction(CalculationAction.Delete)

        val expected = "5"

        assertThat(expected, `is`(viewModel.state.toString()))
    }


    @Test
    fun `OnAction should remove the operator when there is one number, an operator and press Delete`() {
        val viewModel = CalculatorViewModel()
        viewModel.onAction(CalculationAction.Number(55))
        viewModel.onAction(CalculationAction.Operation(CalculatorOperation.Add))
        viewModel.onAction(CalculationAction.Delete)

        val expected = "55"

        assertThat(expected, `is`(viewModel.state.toString()))
    }

    @Test
    fun `OnAction should remove the last number of the second number when there are 2 numbers and press Delete`() {
        val viewModel = CalculatorViewModel()
        viewModel.onAction(CalculationAction.Number(55))
        viewModel.onAction(CalculationAction.Operation(CalculatorOperation.Add))
        viewModel.onAction(CalculationAction.Number(33))
        viewModel.onAction(CalculationAction.Delete)

        val expected = "55+3"

        assertThat(expected, `is`(viewModel.state.toString()))
    }

    @Test
    fun `OnAction should remove all numbers and the operator when press Clear`() {
        val viewModel = CalculatorViewModel()
        viewModel.onAction(CalculationAction.Number(55))
        viewModel.onAction(CalculationAction.Operation(CalculatorOperation.Add))
        viewModel.onAction(CalculationAction.Number(33))
        viewModel.onAction(CalculationAction.Clear)

        val expected = ""

        assertThat(expected, `is`(viewModel.state.toString()))
    }
}