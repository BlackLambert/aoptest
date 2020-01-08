package com.sbaier.aoptest.callCount

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.AfterReturning
import org.springframework.stereotype.Component

@Aspect
@Component
class AddCalculationResultsAspect
{
    private var calculationSum = 0

    @AfterReturning(
            pointcut="execution(* com.sbaier.aoptest.callCount.calculation.*.* (com.sbaier.aoptest.callCount.Calculation))",
            returning="calculationResult")
    fun add(calculationResult: Any)
    {
        val result = calculationResult as CalculationResult
        calculationSum += result.result
        println("The sum of all calculation results is $calculationSum so far.")
    }
}