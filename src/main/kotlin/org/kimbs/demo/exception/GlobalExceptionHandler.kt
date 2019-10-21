package org.kimbs.demo.exception

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import java.time.ZonedDateTime


@RestControllerAdvice
class GlobalExceptionHandler {

    private val log = LoggerFactory.getLogger(GlobalExceptionHandler::class.java);

    @ExceptionHandler(ResourceNotFoundException::class)
    fun resourceNotFoundException(ex: ResourceNotFoundException, request: WebRequest): ResponseEntity<*> {
        val errorDetails = ErrorResponse(ZonedDateTime.now(), HttpStatus.NOT_FOUND.toString(), ex.message!!, request.getDescription(false))
        log.error(errorDetails.toString())
        return ResponseEntity(errorDetails, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(Exception::class)
    fun globalExceptionHandler(ex: Exception, request: WebRequest): ResponseEntity<*> {
        val errorDetails = ErrorResponse(ZonedDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.message!!, request.getDescription(false))
        log.error(errorDetails.toString())
        return ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}