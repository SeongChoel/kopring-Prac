package com.example.upload.global.exception

import com.example.upload.global.dto.Empty
import com.example.upload.global.dto.RsData

class ServiceException(code: String, message: String) : RuntimeException(message) {
    private val rsData: RsData<Empty> = RsData(code, message)

    val code: String
        get() = rsData.code

    val msg: String
        get() = rsData.msg

    val statusCode: Int
        get() = rsData.statusCode
}
