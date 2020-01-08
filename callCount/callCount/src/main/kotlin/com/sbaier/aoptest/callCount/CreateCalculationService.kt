package com.sbaier.aoptest.callCount

import org.springframework.stereotype.Service

@Service
class CreateCalculationService
{
    fun create(first: Int, second: Int): Calculation
    {
        return Calculation(first, second)
    }
}