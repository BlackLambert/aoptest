package com.sbaier.aoptest.callCount

import com.sbaier.aoptest.callCount.calculation.AddService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class AddServiceTest
{
    private val _first = 23
    private val _second = 34
    private lateinit var _calc: Calculation
    private lateinit var _addService: AddService

    @BeforeEach
    fun setUp()
    {
        _addService = AddService()
        _calc = Calculation(_first, _second);
    }

    @Test
    fun add_correctResult()
    {
        val result = _addService.add(_calc)
        assertEquals(result.result, _first + _second)
    }
}