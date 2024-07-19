package br.com.rafaellbarros.controller

import br.com.rafaellbarros.converters.NumberConverter
import br.com.rafaellbarros.exceptions.UnsupportedMathOperationException
import br.com.rafaellbarros.math.SimpleMath
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/math")
class MathController {

    private val math: SimpleMath = SimpleMath()

    @GetMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @GetMapping(value = ["/subtraction/{numberOne}/{numberTwo}"])
    fun subtraction(@PathVariable(value="numberOne") numberOne: String?,
                    @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @GetMapping(value = ["/multiplication/{numberOne}/{numberTwo}"])
    fun multiplication(@PathVariable(value="numberOne") numberOne: String?,
                       @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @GetMapping(value = ["/division/{numberOne}/{numberTwo}"])
    fun division(@PathVariable(value="numberOne") numberOne: String?,
                 @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @GetMapping(value = ["/mean/{numberOne}/{numberTwo}"])
    fun mean(@PathVariable(value="numberOne") numberOne: String?,
             @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @GetMapping(value = ["/squareRoot/{number}"])
    fun squareRoot(@PathVariable(value="number") number: String?
    ): Double {
        if (!NumberConverter.isNumeric(number))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return math.squareRoot(NumberConverter.convertToDouble(number))
    }
}