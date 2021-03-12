package com.financords.data

import com.financords.domain.Result

suspend fun <T: Any> safeApiCall(
    call: suspend () -> Result<T>,
    errorMessage: String
) : Result<T> {
    return try {
        call()
    } catch (e: Exception) {
        Result.Exception(Exception(errorMessage, e))
    }
}