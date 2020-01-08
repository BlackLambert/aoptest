package com.sbaier.aoptest.callCount

import com.sbaier.aoptest.callCount.calculation.AddService
import com.sbaier.aoptest.callCount.calculation.MultiplyService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import kotlin.random.Random

@SpringBootApplication
class CallCountApplication
{
    lateinit var _createCalculationService: CreateCalculationService
    lateinit var _multiplyService: MultiplyService
    lateinit var _addService: AddService

    @Bean
    open fun init(createCalculationService: CreateCalculationService,
                  multiplyService: MultiplyService,
                  addService: AddService) = CommandLineRunner {
        _createCalculationService = createCalculationService
        _multiplyService = multiplyService
        _addService = addService
        calculate()
    }

    private fun createRandomCalculation(): Calculation
    {
        val calc = _createCalculationService.create(Random.nextInt(0,100), Random.nextInt(0,100))
        println("The first number is: ${calc.first} and the second ${calc.second}.")
        return calc
    }

    private fun calculate()
    {
        val calc1 = createRandomCalculation()
        val calc2 = createRandomCalculation()
        val result1 = _multiplyService.multiply(calc1)
        val result2 = _addService.add(calc2)
        val calc3 = Calculation(result1.result, result2.result)
        val result3 = _addService.add(calc3)
        println("The result of the calculation is ${result3.result}")
    }
}

fun main(args: Array<String>) {
	runApplication<CallCountApplication>(*args)
    println("Project created.")
}
