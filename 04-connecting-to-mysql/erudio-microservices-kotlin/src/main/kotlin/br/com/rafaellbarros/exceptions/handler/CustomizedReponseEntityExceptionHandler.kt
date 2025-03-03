package br.com.rafaellbarros.exceptions.handler

import br.com.rafaellbarros.exceptions.ExceptionResponse
import br.com.rafaellbarros.exceptions.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
@RestController
class CustomizedResponseEntityExceptionHandler : ResponseEntityExceptionHandler(){

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest) :
            ResponseEntity<ExceptionResponse> {
        val exceptioResponse = ExceptionResponse(
                Date(),
                ex.message,
                request.getDescription(false)
        )
        return ResponseEntity<ExceptionResponse>(exceptioResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundExceptions(ex: Exception, request: WebRequest) :
            ResponseEntity<ExceptionResponse> {
        val exceptioResponse = ExceptionResponse(
                Date(),
                ex.message,
                request.getDescription(false)
        )
        return ResponseEntity<ExceptionResponse>(exceptioResponse, HttpStatus.NOT_FOUND)
    }
}