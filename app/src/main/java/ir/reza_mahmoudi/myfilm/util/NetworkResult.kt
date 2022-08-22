package ir.reza_mahmoudi.myfilm.util

sealed class NetworkResult<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : NetworkResult<T>(data, null)
    class Error<T>(message: String, data: T? = null) : NetworkResult<T>(null, message)
}