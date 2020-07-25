package com.veglad.springblog.controller.advice

import com.veglad.springblog.errors.ArticleNotFoundError
import com.veglad.springblog.errors.UserNotFound
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class GlobalExceptionHandle {
    @ExceptionHandler(
            ArticleNotFoundError::class,
            UserNotFound::class
    )
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    fun handleNotFoundExceptions(ex: Exception) = ex.message
}
