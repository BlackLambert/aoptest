package com.sbaier.aoptest.callCount.calculation

import com.sbaier.aoptest.callCount.Calculation
import com.sbaier.aoptest.callCount.CalculationResult
import org.springframework.stereotype.Service

@Service
class AddService
{
    fun add(calc: Calculation): CalculationResult
    {
        val result = calc.first + calc.second
        return CalculationResult(result)
    }
}