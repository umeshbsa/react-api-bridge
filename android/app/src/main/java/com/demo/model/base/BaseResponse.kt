package com.demo.model.base

class BaseResponse<T> {

    var statusCode = 0
    var responseData: T? = null
    var error: Errors? = null
}