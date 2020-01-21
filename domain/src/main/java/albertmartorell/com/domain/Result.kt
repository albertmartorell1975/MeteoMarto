package albertmartorell.com.domain

/**
 * I use sealed class to wrap-up the response in Success and in the Error case from networking (Retrofit) response
 */
const val ERROR_HTTP = "400"
const val ERROR_SERVER = "500"
const val ERROR_INTERNET = "0"

sealed class Result<out T> {

    data class Success<out T>(val value: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}