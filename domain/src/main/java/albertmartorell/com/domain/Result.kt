package albertmartorell.com.domain

/**
 * I use sealed class to wrap-up the response in Success and in the Error case from networking (Retrofit) response
 */
sealed class Result<out T> {
    data class Success<out T>(val value: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}