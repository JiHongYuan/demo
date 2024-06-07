package com.example.demo

import org.springframework.http.HttpStatus

class Result<T> private constructor(
    /** result code */
    var code: Int,
    /** result msg */
    var msg: String,
    /** result data */
    var data: T?
) {

    fun success(msg: String, data: T): Result<T> {
        return Result(HttpStatus.OK.value(), msg, data);
    }

    fun error(httpStatus: HttpStatus, msg: String, data: T): Result<T> {
        return Result(httpStatus.value(), msg, data);
    }

}